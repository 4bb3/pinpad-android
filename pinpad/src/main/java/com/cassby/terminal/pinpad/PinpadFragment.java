package com.cassby.terminal.pinpad;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class PinpadFragment extends Fragment {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;

    private ImageView oval1;
    private ImageView oval2;
    private ImageView oval3;
    private ImageView oval4;

    private Button back;
    private Button delete;

    private String code = "";
    private PinpadInterface output;
    private Integer color = null;
    private Integer keyColor = null;

    private ConstraintLayout dots;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pinpad, container, false);

        button1 = view.findViewById(R.id.pinpan_1button);
        button2 = view.findViewById(R.id.pinpan_2button);
        button3 = view.findViewById(R.id.pinpan_3button);
        button4 = view.findViewById(R.id.pinpan_4button);
        button5 = view.findViewById(R.id.pinpan_5button);
        button6 = view.findViewById(R.id.pinpan_6button);
        button7 = view.findViewById(R.id.pinpan_7button);
        button8 = view.findViewById(R.id.pinpan_8button);
        button9 = view.findViewById(R.id.pinpan_9button);
        button0 = view.findViewById(R.id.pinpan_0button);

        oval1 = view.findViewById(R.id.pinpad_1oval);
        oval2 = view.findViewById(R.id.pinpad_2oval);
        oval3 = view.findViewById(R.id.pinpad_3oval);
        oval4 = view.findViewById(R.id.pinpad_4oval);

        dots = view.findViewById(R.id.dotsContainer);

        delete = view.findViewById(R.id.pinpad_delete);
        back = view.findViewById(R.id.pinpad_back);

        if (color != null) {
            oval1.setColorFilter(color);
            oval2.setColorFilter(color);
            oval3.setColorFilter(color);
            oval4.setColorFilter(color);

            GradientDrawable drawable = (GradientDrawable) button0.getBackground();
            drawable.setStroke(2, color);

            GradientDrawable drawable1 = (GradientDrawable) button1.getBackground();
            drawable1.setStroke(2, color);

            GradientDrawable drawable2 = (GradientDrawable) button2.getBackground();
            drawable2.setStroke(2, color);

            GradientDrawable drawable3 = (GradientDrawable) button3.getBackground();
            drawable3.setStroke(2, color);

            GradientDrawable drawable4 = (GradientDrawable) button4.getBackground();
            drawable4.setStroke(2, color);

            GradientDrawable drawable5 = (GradientDrawable) button5.getBackground();
            drawable5.setStroke(2, color);

            GradientDrawable drawable6 = (GradientDrawable) button6.getBackground();
            drawable6.setStroke(2, color);

            GradientDrawable drawable7 = (GradientDrawable) button7.getBackground();
            drawable7.setStroke(2, color);

            GradientDrawable drawable8 = (GradientDrawable) button8.getBackground();
            drawable8.setStroke(2, color);

            GradientDrawable drawable9 = (GradientDrawable) button9.getBackground();
            drawable9.setStroke(2, color);

            back.setTextColor(color);
            delete.setTextColor(color);
        }

        if (keyColor != null) {
            button0.setTextColor(keyColor);
            button1.setTextColor(keyColor);
            button2.setTextColor(keyColor);
            button3.setTextColor(keyColor);
            button4.setTextColor(keyColor);
            button5.setTextColor(keyColor);
            button6.setTextColor(keyColor);
            button7.setTextColor(keyColor);
            button8.setTextColor(keyColor);
            button9.setTextColor(keyColor);

        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code = deleteLastChar(code);
                fillOrUnfillCode();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (output != null) {
                    output.didPressBack();
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("7");
            }
        });


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPress("0");
            }
        });

        return view;
    }

    private void onButtonPress(String symbol) {
        if (code.length() < 4) {
            code = code + symbol;
            fillOrUnfillCode();
            if (code.length() == 4) {
                if (output != null) {
                    output.didSubmitCode(code);
                }
            }
        }
    }

    private void fillOrUnfillCode() {
        switch (code.length()) {
            case 0:
                oval1.setImageResource(R.drawable.oval);
                oval2.setImageResource(R.drawable.oval);
                oval3.setImageResource(R.drawable.oval);
                oval4.setImageResource(R.drawable.oval);
                hideDelete();
                break;
            case 1:
                oval1.setImageResource(R.drawable.oval_filled);
                oval2.setImageResource(R.drawable.oval);
                oval3.setImageResource(R.drawable.oval);
                oval4.setImageResource(R.drawable.oval);
                showDelete();
                break;
            case 2:
                oval2.setImageResource(R.drawable.oval_filled);
                oval3.setImageResource(R.drawable.oval);
                oval4.setImageResource(R.drawable.oval);
                showDelete();
                break;
            case 3:
                oval3.setImageResource(R.drawable.oval_filled);
                oval4.setImageResource(R.drawable.oval);
                showDelete();
                break;
            case 4:
                oval4.setImageResource(R.drawable.oval_filled);
                showDelete();
                break;
            default:
                break;
        }
    }

    private String deleteLastChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public void hideBack() {
        back.setVisibility(View.INVISIBLE);
    }

    public void showBack() {
        back.setVisibility(View.VISIBLE);
    }

    public void hideDelete() {
        delete.setVisibility(View.INVISIBLE);
    }

    public void showDelete() {
        delete.setVisibility(View.VISIBLE);
    }

    public void setTint(int red, int green, int blue) {
        this.color = Color.argb(255, red, green, blue);
    }

    public void setKeyColor(int red, int green, int blue) {
        this.keyColor = Color.argb(255, red, green, blue);
    }

    public void showErrorAnimation() {
        ObjectAnimator
                .ofFloat(dots, "translationX", 0, 25, -25, 25, -25,15, -15, 6, -6, 0)
                .setDuration(1500)
                .start();
    }

    public void setOutput(PinpadInterface output) {
        this.output = output;
    }
}
