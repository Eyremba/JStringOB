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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import net.anana.jstringob.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * MADE BY ANANA WITH ♥
 * FOR THE DEVELOPPERS;
 */
public class HomeWindow extends Stage {

    /**
     * Get the Home Window FX Stage
     */
    public HomeWindow() {
        setHeight(160.0);
        setWidth(410.0);

        Group root = new Group();

        TextField field = new TextField();
        field.setLayoutX(181.0);
        field.setLayoutY(50.0);

        TextField value = new TextField();
        value.setLayoutX(181.0);
        value.setLayoutY(16.0);

        Button button = new Button(Messages.OBFUSCATE);
        button.setLayoutX(330.0);
        button.setLayoutY(87.0);
        button.setOnAction(event -> {
            if (field.getText().length() > 50 || value.getText().length() > 50
                    || field.getText() == null || value.getText() == null) {
                System.exit(0);
                return;
            }

            new CodeDialog(value.getText(), field.getText()).show();
        });

        List<Node> nodes = new ArrayList<>();
        nodes.add(getLabel(Messages.OBFUSCATE_VALUE, 25.0, 20.0));
        nodes.add(value);
        nodes.add(getLabel(Messages.VARIABLE_VALUE, 40.0, 55.0));
        nodes.add(field);
        nodes.add(button);

        for (Node nds : nodes)
            root.getChildren().add(nds);

        setTitle("Java String Obfuscator");
        setResizable(false);
        setScene(new Scene(root));
    }

    /**
     * Get a JFX Label
     *
     * @param name
     * @param x
     * @param y
     * @return
     */
    private Label getLabel(String name, double x, double y) {
        Label label = new Label(name);
        label.setLayoutX(x);
        label.setLayoutY(y);
        return label;
    }

}
