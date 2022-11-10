package MiniProject;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorV2 extends Frame {
    final int FRAME_WIDTH = 325, FRAME_HEIGHT = 325;
    final int HEIGHT = 30, WIDTH = 30, H_SPACE = 10, V_SPACE = 10;
    final int TOPX = 30, TOPY = 50;

    private boolean setClear = true;
    private double number, memValue;
    private char op;

    private final Label displayLabel = new Label("0", Label.RIGHT);
    private final Label memLabel = new Label(" ", Label.RIGHT);

    public CalculatorV2(String frameText) {
        super(frameText);

        int tempX = TOPX;
        displayLabel.setBounds(tempX, TOPY, 240, HEIGHT);
        displayLabel.setBackground(Color.BLUE);
        displayLabel.setForeground(Color.WHITE);
        add(displayLabel);

        memLabel.setBounds(TOPX, TOPY + HEIGHT + V_SPACE, WIDTH, HEIGHT);
        add(memLabel);

        ButtonInfo[] memoryButtonInfos = {
                new ButtonInfo("MC", e -> {
                    this.setClear = true;
                    this.memLabel.setText(" ");
                    this.memValue = 0.0;
                }),
                new ButtonInfo("MR", e -> {
                    this.setClear = true;
                    this.displayLabel.setText(getFormattedText(this.memValue));
                }),
                new ButtonInfo("MS", e -> {
                    this.setClear = true;
                    this.memValue = 0.0;
                    this.memValue += Double.parseDouble(this.displayLabel.getText());
                    if (this.displayLabel.getText().equals("0") ||
                            this.displayLabel.getText().equals("0.0"))
                        this.memLabel.setText(" ");
                    else
                        this.memLabel.setText("M");
                }),
                new ButtonInfo("M+", e -> {
                    this.setClear = true;
                    this.memValue += Double.parseDouble(this.displayLabel.getText());
                    if (this.displayLabel.getText().equals("0") ||
                            this.displayLabel.getText().equals("0.0"))
                        this.memLabel.setText(" ");
                    else
                        this.memLabel.setText("M");
                })
        };

        // set Co-ordinates for Memory Buttons
        int y = TOPY + 2 * (HEIGHT + V_SPACE);
        /*for (ButtonInfo info : memoryButtonInfos) {
            CalcButton button = new CalcButton(tempX, y, WIDTH, HEIGHT, info.display, this, info.listener);
            button.setForeground(Color.RED);
            y += HEIGHT + V_SPACE;
        }*/

        ButtonInfo[] specialButtonInfos = {
                new ButtonInfo("Backspc", e -> {
                    String rem = this.displayLabel.getText().substring(0, this.displayLabel.getText().length() - 1);
                    if (rem.equals("")) {
                        this.displayLabel.setText("0");
                        setClear = true;
                    } else
                        this.displayLabel.setText(rem);
                }),
                new ButtonInfo("C", e -> {
                    this.number = 0.0;
                    this.op = ' ';
                    this.memValue = 0.0;
                    this.memLabel.setText(" ");
                }),
                new ButtonInfo("CE", e -> {
                    this.displayLabel.setText("0");
                    this.setClear = true;
                })
        };

        //set Co-ordinates for Special Buttons
        tempX = TOPX + (WIDTH + H_SPACE);
        y = TOPY + (HEIGHT + V_SPACE);
        for (ButtonInfo info : specialButtonInfos) {
            CalcButton button = new CalcButton(tempX, y, WIDTH * 2, HEIGHT, info.display, this, info.listener);
            button.setForeground(Color.RED);
            tempX = tempX + 2 * WIDTH + H_SPACE;
        }

        ButtonInfo[] digitButtonInfos = {
                new ButtonInfo("7", createDigitActionListener(7)),
                new ButtonInfo("8", createDigitActionListener(8)),
                new ButtonInfo("9", createDigitActionListener(9)),
                new ButtonInfo("4", createDigitActionListener(4)),
                new ButtonInfo("5", createDigitActionListener(5)),
                new ButtonInfo("6", createDigitActionListener(6)),
                new ButtonInfo("1", createDigitActionListener(1)),
                new ButtonInfo("2", createDigitActionListener(2)),
                new ButtonInfo("3", createDigitActionListener(3)),
                new ButtonInfo("0", e -> {
                    if (this.setClear) return;
                    this.displayLabel.setText(this.displayLabel.getText() + 0);
                })/*,
                new ButtonInfo("+/-", e -> {
                    //TODO add the lambda for this.
                }),
                new ButtonInfo(".", e -> {
                    if (this.setClear) {
                        this.displayLabel.setText("0.");
                        this.setClear = false;
                    } else if (!this.displayLabel.getText().contains("."))
                        this.displayLabel.setText(this.displayLabel.getText() + ".");
                })*/
        };

        //set Co-ordinates for Digit Buttons
        int digitX = TOPX + WIDTH + H_SPACE;
        int digitY = TOPY + 2 * (HEIGHT + V_SPACE);
        tempX = digitX;
        y = digitY;
        int index = 0;
        for (ButtonInfo info : digitButtonInfos) {
            CalcButton button = new CalcButton(tempX, y, WIDTH, HEIGHT, info.display, this, info.listener);
            button.setForeground(Color.BLUE);
            tempX += WIDTH + H_SPACE;
            if ((index++ + 1) % 3 == 0) {
                tempX = digitX;
                y += HEIGHT + V_SPACE;
            }
        }

        ButtonInfo[] operatorButtonInfos = {
                /*new ButtonInfo("/", createOpActionListener('/')),
                new ButtonInfo("sqrt", e -> {
                    this.setClear = true;
                    try {
                        double tempd = Math.sqrt(Double.parseDouble(this.displayLabel.getText()));
                        this.displayLabel.setText(getFormattedText(tempd));
                    } catch (ArithmeticException exc) {
                        this.displayLabel.setText("Divide by 0.");
                    }
                }),*/
                new ButtonInfo("cubrt", e -> {
                    this.setClear = true;
                    try {
                        double tempd = Math.cbrt(Double.parseDouble(this.displayLabel.getText()));
                        this.displayLabel.setText(getFormattedText(tempd));
                    } catch (ArithmeticException exc) {
                        this.displayLabel.setText("Divide by 0.");
                    }
                }),
                /*new ButtonInfo("*", createOpActionListener('*')),
                new ButtonInfo("%", createOpActionListener('%')),
                new ButtonInfo("-", createOpActionListener('-')),
                new ButtonInfo("1/X", e -> {
                    try {
                        this.setClear = true;
                        double tempd = 1 / Double.parseDouble(this.displayLabel.getText());
                        this.displayLabel.setText(getFormattedText(tempd));
                    } catch (ArithmeticException exc) {
                        this.displayLabel.setText("Divide by 0.");
                    }
                }),
                new ButtonInfo("+", createOpActionListener('+')),*/
                new ButtonInfo("=", e -> {
                    this.setClear = true;
                    double temp = Double.parseDouble(this.displayLabel.getText());
                    switch (this.op) {
                        case '+':
                            temp += this.number;
                            break;
                        case '-':
                            temp = this.number - temp;
                            break;
                        case '*':
                            temp *= this.number;
                            break;
                        case '%':
                            try {
                                temp = this.number % temp;
                            } catch (ArithmeticException excp) {
                                this.displayLabel.setText("Divide by 0.");
                                return;
                            }
                            break;
                        case '/':
                            try {
                                temp = this.number / temp;
                            } catch (ArithmeticException excp) {
                                this.displayLabel.setText("Divide by 0.");
                                return;
                            }
                            break;
                    }
                    this.displayLabel.setText(getFormattedText(temp));
                })
        };

        //set Co-ordinates for Operator Buttons
        int opsX = digitX + 2 * (WIDTH + H_SPACE) + H_SPACE;
        tempX = opsX;
        y = digitY;
        index = 0;
        for (ButtonInfo info : operatorButtonInfos) {
            tempX += WIDTH + H_SPACE;
            CalcButton button = new CalcButton(tempX, y, WIDTH * 2, HEIGHT, info.display, this, info.listener);
            button.setForeground(Color.RED);
            if ((++index) % 2 == 0) {
                tempX = opsX;
                y += HEIGHT + V_SPACE;
            }
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });

        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }

    private ActionListener createDigitActionListener(int digit) {
        return e -> {
            if (this.setClear) {
                this.displayLabel.setText("" + digit);
                this.setClear = false;
            } else
                this.displayLabel.setText(this.displayLabel.getText() + digit);
        };
    }

    private ActionListener createOpActionListener(char op) {
        return e -> {
            this.number = Double.parseDouble(this.displayLabel.getText());
            this.op = op;
            this.setClear = true;
        };
    }

    private String getFormattedText(double temp) {
        return ("" + temp).lastIndexOf(".0") > 0 ? ("" + temp).substring(0, ("" + temp).length() - 2) : "" + temp;
    }

    public static void main(String[] args) {
        new CalculatorV2("Calculator");
    }

    private record ButtonInfo(String display, ActionListener listener) {

    }

    private static class CalcButton extends Button {
        public CalcButton(int x, int y, int width, int height, String cap, CalculatorV2 clc, ActionListener listener) {
            super(cap);
            setBounds(x, y, width, height);
            clc.add(this);
            addActionListener(listener);
        }
    }
}
