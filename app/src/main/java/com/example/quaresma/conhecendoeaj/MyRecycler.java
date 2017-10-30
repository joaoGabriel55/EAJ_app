package com.example.quaresma.conhecendoeaj;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MyRecycler implements RecyclerView.OnItemTouchListener {

    OnItemClickListener myListener;
    GestureDetector myGestureDetector;

    public MyRecycler(Context context, final RecyclerView view , OnItemClickListener listener) {
        myListener = listener;
        myGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                super.onSingleTapUp(motionEvent);
                View childView = view.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
                if (childView != null && myListener != null ) {
                    myListener.onItemClick(childView, view.getChildAdapterPosition(childView));
                    Log.i("Teste", "onSingleTapUp ");
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
                View childView = view.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(childView != null && myListener != null){
                    myListener.onItemLongClick(childView,view.getChildAdapterPosition(childView));
                    Log.i("Teste", "onLongPress");
                }
            }
        });
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Log.i("TouchEvent", "onInterceptTouchEvent");
        myGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        Log.i("TouchEvent", "onTouchEvent");

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Log.i("TouchEvent", "onRequestDisallowInterceptTouchEvent");

    }
}
