package br.com.brewjas.services.scroll;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
 * Empresa : Brewjas app.
 */
public interface EndlessScrollListener {
    void onScrollChanged(EndlessScrollView scrollView, int x, int y, int oldx, int oldy);
}
