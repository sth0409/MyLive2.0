package com.example.sth0409.mylive20.CardSlidePanel;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sth0409.mylive20.R;


/**
 * 卡片View项
 *
 * @author xmuSistone
 */
public class CardItemView extends FrameLayout {
    private TextView tv_title;
    private TextView tv_author;
    public View maskView;
    private ImageView imageView;
    private View shadeView;
    private CardSlidePanel parentView;
    private Context context;
    private View topLayout, bottomLayout;

    public CardItemView(Context context) {
        this(context, null);
    }

    public CardItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //  app:roundedCornerRadius="6dp"
        this.context = context;
        inflate(context, R.layout.card_item, this);
        maskView = findViewById(R.id.maskView);
        imageView = (ImageView) findViewById(R.id.card_image_view);
        shadeView = findViewById(R.id.shade);
        tv_title = (TextView) findViewById(R.id.tv_video_title);
        tv_author = (TextView) findViewById(R.id.tv_video_author);
        topLayout = imageView;
        bottomLayout = findViewById(R.id.bottomLayout);
    }

    public void fillData(CardDataItem itemData) {
        Glide.with(context)
                .load(itemData.getImagePath())
                .override(320, 320)
                .centerCrop()
                .into(imageView);
        tv_title.setText(itemData.getTitle());
        tv_author.setText(itemData.getAuthor());
        // imageView.setImageURI(Uri.parse(itemData.imagePath));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 兼容ViewPager，触点需要按在可滑动区域才行
            boolean shouldCapture = shouldCapture((int) ev.getX(), (int) ev.getY());
            Log.i("---", "dispatchTouchEvent: " + shouldCapture);
            if (shouldCapture) {
                parentView.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public void setShadeLayer(int shaderLayer) {
        shadeView.setBackgroundResource(shaderLayer);
    }

    public void setParentView(CardSlidePanel parentView) {
        this.parentView = parentView;
    }

    /**
     * 判断(x, y)是否在可滑动的矩形区域内
     * 这个函数也被CardSlidePanel调用
     *
     * @param x 按下时的x坐标
     * @param y 按下时的y坐标
     * @return 是否在可滑动的矩形区域
     */
    public boolean shouldCapture(int x, int y) {
        int captureLeft = topLayout.getLeft() + topLayout.getPaddingLeft();
        int captureTop = topLayout.getTop() + topLayout.getPaddingTop();
        int captureRight = bottomLayout.getRight() - bottomLayout.getPaddingRight();
        int captureBottom = bottomLayout.getBottom() - bottomLayout.getPaddingBottom();

        if (x > captureLeft && x < captureRight && y > captureTop && y < captureBottom) {
            return true;
        }
        return false;
    }
}
