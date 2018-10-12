package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.zivari.mylibs.R;

public class myEditText extends android.support.v7.widget.AppCompatEditText {
    String [] font_arr=new String[]{"iranyekan_regular","IranSans","BYekan","CasablancaHeavy"};
    public myEditText(Context context) {
        super(context);
        init(null);
    }

    public myEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public myEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

//    public myEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    void init(AttributeSet attrs){

        if(attrs!=null){

           TypedArray typedArray=getContext().obtainStyledAttributes(attrs, R.styleable.myEditText);

           attr_font(typedArray);
           attr_radius(typedArray);

           typedArray.recycle();
        }
    }

    void attr_font(TypedArray typedArray){

        int index=typedArray.getInt(R.styleable.myEditText_edt_font_name,0);
        String fontName=font_arr[index];

        Typeface typeface=Typeface.createFromAsset(getContext().getAssets(),"fonts/"+fontName+".ttf");
        setTypeface(typeface);

    }
    void attr_radius(TypedArray typedArray){

        boolean set_radius=typedArray.getBoolean(R.styleable.myEditText_edt_set_radius,false);
        if(!set_radius)
            return;

        int radius=typedArray.getInt(R.styleable.myEditText_edt_radius,10);
        int color=typedArray.getColor(R.styleable.myEditText_edt_radius_color,getResources().getColor(R.color.colorPrimary));

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(color);
        gd.setCornerRadius(radius);
        gd.setStroke(0, 0xFF000000);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackground(gd);
            this.setTextColor(Color.parseColor("#ffffff"));
        }

    }


}
