/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.generator;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/4/13
 *         Time: 3:27 PM
 */
public final class ReadmeGenerator {

    private ReadmeGenerator() {
    }

    public static class Tuple {
        private String title;
        private String detail;

        public Tuple(String title, String detail) {
            this.title = title;
            this.detail = detail;
        }

        public Tuple() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

    public static void main(String[] args) throws IOException, TemplateException {
        ResourceBundle hrb = ResourceBundle.getBundle("help");
        ResourceBundle urb = ResourceBundle.getBundle("usage");
        List<Tuple> tuples = new ArrayList<Tuple>();

        ArrayList<String> list = Collections.list(urb.getKeys());
        Collections.sort(list);
        for (String s : list) {
            tuples.add(new Tuple(urb.getString(s), hrb.getString(s.replace("usage.", "help."))));
        }

        Configuration cfg = new Configuration();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("items", tuples);

        cfg.setDirectoryForTemplateLoading(
                new File("src/main/resources/freemarker/"));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        freemarker.template.Template temp = cfg.getTemplate("readme.ftl");

        Writer out = new FileWriter(new File("README.md"));
        temp.process(map, out);
        out.flush();
        out.close();

    }
}