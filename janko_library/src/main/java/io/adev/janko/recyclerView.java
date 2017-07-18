package io.adev.janko;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

public class recyclerView extends RecyclerView implements JankoContextProvider<RecyclerView> {

    private final JankoContext<RecyclerView> jankoContext;

    public recyclerView(Context context) {
        super(context);
        jankoContext = new JankoContext<>(context, RecyclerView.class);
    }

    public recyclerView(Activity activity) {
        super(activity);
        jankoContext = new JankoContext<>(activity, RecyclerView.class);
    }

    public recyclerView(JankoContext rootJankoContext) {
        super(rootJankoContext.context);
        jankoContext = new JankoContext<>(rootJankoContext.context, RecyclerView.class);
    }

    public recyclerView(JankoContextProvider rootContextProvider) {
        super(rootContextProvider.getJankoContext().context);
        jankoContext = new JankoContext<>(rootContextProvider, RecyclerView.class);
    }

    @Override
    public JankoContext getJankoContext() {
        return jankoContext;
    }

    public int backgroundColor = -1;
    public OnClickListener onClickListener;
    public LayoutManager layoutManager;
    public RecyclerView.Adapter adapter;

    @Override
    public RecyclerView _() {

        if (backgroundColor != -1) { setBackgroundColor(backgroundColor); }
        if (onClickListener != null) { setOnClickListener(onClickListener); }
        if (layoutManager != null) { setLayoutManager(layoutManager); }
        if (adapter != null) { setAdapter(adapter); }

        return jankoContext.build(this);
    }

}