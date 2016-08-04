/*
MIT License

Copyright (c) 2016 Anana

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package net.anana.jstringob.utils;

import java.util.Random;

/**
 * MADE BY ANANA WITH ♥
 * FOR THE DEVELOPPERS;
 */
public class Obfuscator {

    private String value;
    private String field;

    /**
     * Instantiate the Obfuscator with the Value to Obfuscate
     * and the Variable name
     *
     * @param value
     * @param field
     */
    public Obfuscator(String value, String field) {
        this.value = value;
        this.field = field;
    }

    /**
     * Obfuscate the Value and get the Colored code on HTML
     *
     * @return
     */
    public String obfuscate() {
        Random r = new Random(System.currentTimeMillis());
        byte[] b = value.getBytes();
        int c = b.length;

        String result = "String " + field + " = new Object() {\n" +
                "   @Override\n" +
                "   public String toString() {\n" +
                "       byte[] b = new byte[" + c + "];\n";
        StringBuilder builder = new StringBuilder(result);

        for (int i = 0; i < c; ++i) {
            int t = r.nextInt();
            int f = r.nextInt(24) + 1;

            t = (t & ~(0xff << f)) | (b[i] << f);

            builder.append("        b[" + i + "] = (byte) (" + t + " >>> " + f + ");\n");
        }

        builder.append("        return new String(b);\n" +
                "   }\n" +
                "}.toString();");

        return builder.toString();
    }

}
