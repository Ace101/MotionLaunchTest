package com.aroutertest.motionlaunchtest;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.wangnan.library.painter.Painter;

/**
 * @author zhangshihao
 * @date 2018/12/14 0014
 */
public class MyPainter extends Painter {

    /**
     * 绘制正常状态的点
     *
     * @param point       单位点
     * @param canvas      画布
     * @param normalPaint 正常状态画笔
     */
    @Override
    public void drawNormalPoint(com.wangnan.library.model.Point point, Canvas canvas, Paint normalPaint) {
        canvas.drawCircle(point.x, point.y, point.radius / 4.0F, normalPaint);
    }

    @Override
    public void drawPressPoint(com.wangnan.library.model.Point point, Canvas canvas, Paint pressPaint) {
        canvas.drawCircle(point.x, point.y, point.radius / 4.0F, pressPaint);
    }

    @Override
    public void drawErrorPoint(com.wangnan.library.model.Point point, Canvas canvas, Paint errorPaint) {
        canvas.drawCircle(point.x, point.y, point.radius / 4.0F, errorPaint);
    }
}
