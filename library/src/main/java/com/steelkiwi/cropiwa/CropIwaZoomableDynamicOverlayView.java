package com.steelkiwi.cropiwa;

import android.content.Context;
import android.view.MotionEvent;

import com.steelkiwi.cropiwa.config.CropIwaOverlayConfig;

/**
 * @author Yaroslav Polyakov https://github.com/polyak01
 * 2/19/2019 © epam.com
 */

public class CropIwaZoomableDynamicOverlayView extends CropIwaDynamicOverlayView {

    public CropIwaZoomableDynamicOverlayView(Context context, CropIwaOverlayConfig config) {
        super(context, config);
    }

    @Override
    public boolean isDraggingCropArea() {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!shouldDrawOverlay) {
            return false;
        }
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                onStartGesture(ev);
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                onPointerDown(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                onPointerMove(ev);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                onPointerUp(ev);
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                onEndGesture();
                break;
            default:
                return true;
        }
        invalidate();
        return true;
    }
}
