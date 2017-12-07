package com.pers.lzl.modules.dpt.web;

import com.pers.lzl.common.utils.DateUtils;
import com.pers.lzl.common.utils.JsonMaker;
import com.pers.lzl.common.utils.excel.ExportExcel;
import com.pers.lzl.common.utils.excel.ImportExcel;
import com.pers.lzl.common.utils.excel.TransformUtils;
import com.pers.lzl.modules.dpt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
@RequestMapping("dpt")
public class ExportController {

    private static List<User> users;

    static {
        String jsonStr = JsonMaker.getJsonResult(20);
        users = TransformUtils.getEntityArray(jsonStr, User.class);
    }

    /**
     * 导出Excel数据
     * @param ids
     * @param response
     * @return
     */
    @RequestMapping(value = "export/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public String exportExcel(@PathVariable String ids, HttpServletResponse response) {
        String[] str = ids.split(",");
        try {
            List<User> result = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                for (int j = 0; j < users.size(); j++) {
                    if (str[i].equals(String.valueOf(users.get(j).getAge()))) {
                        result.add(users.get(j));
                        break;
                    }
                }
            }
            String fileName = "启尚导出Excel测试_" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            new ExportExcel("员工状况", User.class).setDataList(result).write(response, fileName).dispose();
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    /**
     * 导出模板
     * @param response
     * @return
     */
    @RequestMapping(value = "template")
    @ResponseBody
    public String template(HttpServletResponse response) {
        try {
            new ExportExcel("员工状况模板", User.class, 2).write(response, "启尚用户模板.xlsx").dispose();
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    /**
     * 导入Excel
     * @param file
     * @param model
     * @return
     */
    @RequestMapping(value = "import", method = RequestMethod.POST)
    public String importExcel(MultipartFile file, Map<String, Object> model) {
        try {
            ImportExcel ei = new ImportExcel(file, 1, 0);
            List<User> list = ei.getDataList(User.class);
            for (User user : list) {
                System.out.println(user);
            }
            model.put("msg", "已成功导入");
            model.put("users", list);
        } catch (Exception e) {
            model.put("msg", "导入用户失败！");
        }
        return "index";


    }

    /**
     * 主页
     * @param model
     * @return
     */
    @RequestMapping(value = "index")
    public String index(Map<String, Object> model) {
        model.put("title", "A sample of import and export Microsoft Excel by Spring Boot");
        model.put("users", users);
        return "index";
    }

    /**
     * 图片文件上传
     * @param model
     * @return
     */
    @RequestMapping(value = "upload")
    public String upload(Map<String, Object> model) {
        model.put("title", "upload pictures");
        return "upload";
    }


    /**
     * 根据文件链接把文件下载下来
     * @param
     * @return
     */
    @RequestMapping(value = "toZip")
    @ResponseBody
    public String toZip(HttpServletResponse response) {
        try {
            String filename = new String("qs压缩包.zip".getBytes("UTF-8"), "ISO8859-1");//控制文件名编码
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zos = new ZipOutputStream(bos);
            int idx = 1;
            String[] urls = {"https://imgsa.baidu.com/news/q%3D100/sign=72d95d9bbb7eca8014053de7a1229712/3b292df5e0fe99257cf992e83fa85edf8cb17195.jpg",
                    "https://imgsa.baidu.com/news/q%3D100/sign=93821dbd3f9b033b2a88f8da25cf3620/9a504fc2d5628535a275d2989bef76c6a6ef63f5.jpg",
                    "https://imgsa.baidu.com/news/pic/item/e824b899a9014c0806fab61d017b02087af4f441.jpg"};
            for (String oneFile : urls) {
                zos.putNextEntry(new ZipEntry("profile" + idx + ".jpg"));
                byte[] bytes = getImageFromURL(oneFile);
                zos.write(bytes, 0, bytes.length);
                zos.closeEntry();
                idx++;
            }

            zos.close();
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + filename);// 设置文件名
            OutputStream os = response.getOutputStream();
            os.write(bos.toByteArray());
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "success";
    }

    public byte[] getImageFromURL(String urlPath) {
        byte[] data = null;
        InputStream is = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            // conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(6000);
            is = conn.getInputStream();
            if (conn.getResponseCode() == 200) {
                data = readInputStream(is);
            } else {
                data = null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            conn.disconnect();
        }
        return data;
    }

    public byte[] readInputStream(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = -1;
        try {
            while ((length = is.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = baos.toByteArray();
        try {
            is.close();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


}
