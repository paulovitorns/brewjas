package br.com.brewjas.services.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class EndlessScrollView extends ScrollView {

    private EndlessScrollListener endlessScrollListener  = null;

    public EndlessScrollView(Context context) {
        super(context);
    }

    public EndlessScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public EndlessScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollViewListener(EndlessScrollListener endlessScrollListener) {
        this.endlessScrollListener = endlessScrollListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (endlessScrollListener != null) {
            endlessScrollListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

}
