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

package net.anana.jstringob.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import net.anana.jstringob.utils.Obfuscator;

/**
 * MADE BY ANANA WITH ♥
 * FOR THE DEVELOPPERS;
 */
public class CodeDialog extends Stage {

    /**
     * Get the code dialog FX Stage
     *
     * @param value
     * @param field
     */
    public CodeDialog(String value, String field) {
        Group root = new Group();

        TextArea textArea = new TextArea(new Obfuscator(value, field).obfuscate());
        root.getChildren().add(textArea);

        setTitle("Code");
        setResizable(false);
        setScene(new Scene(root));
    }

}
