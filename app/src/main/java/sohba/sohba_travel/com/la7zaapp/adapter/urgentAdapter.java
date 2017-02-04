package sohba.sohba_travel.com.la7zaapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import sohba.sohba_travel.com.la7zaapp.R;
import sohba.sohba_travel.com.la7zaapp.model.urgentModel;
import sohba.sohba_travel.com.la7zaapp.util.SetFont;


public class urgentAdapter extends RecyclerView.Adapter<urgentAdapter.MyViewHolder> {
    private List<urgentModel> itemList;

    private int lastPosition = -1;

    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productTitle;
        // change it to networkImageView
        public ImageView productImage;
        public View urgent_color;

        CardView container;

        public MyViewHolder(View view) {
            super(view);
//            container= (CardView) view.findViewById(R.id.card_view_container);
//            productTitle = (TextView) view.findViewById(R.id.product_title);
//            productImage = (ImageView) view.findViewById(R.id.product_image);
            urgent_color = view.findViewById(R.id.urgent_color);


            SetFont setFont = new SetFont();
            setFont.changeFonts(context, (CardView) view.findViewById(R.id.card_view_container));
            setFont.changeFonts(context, (LinearLayout) view.findViewById(R.id.parent_id11));

        }
    }

    public urgentAdapter(Context c, List<urgentModel> moviesList) {
        this.itemList = moviesList;
        context = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_urgent, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        categModel productData = itemList.get(position);
//        holder.productTitle.setText(productData.getTitle());
        if (position % 2 == 0)
            holder.urgent_color.setBackgroundColor(context.getResources().getColor(R.color.color_urgent1));
        else if (position%3==0)
            holder.urgent_color.setBackgroundColor(context.getResources().getColor(R.color.color_urgent2));

        if (position==0)
            holder.urgent_color.setBackgroundColor(context.getResources().getColor(R.color.color_urgent3));
        if (position==1)
            holder.urgent_color.setBackgroundColor(context.getResources().getColor(R.color.color_urgent2));

        //        holder.productTitle.setText(productData.getName());
//
//
//        final String url = productData.getImage();
//
//
//        mImageLoader = CustomVolleyRequestQueue.getInstance(context.getApplicationContext())
//                .getImageLoader();
//        //Image URL - This can point to any image file supported by Android
//        mImageLoader.get(url, ImageLoader.getImageListener(holder.productImage,
//                R.drawable.default_icon, R.drawable
//                        .error_loading_icon));
//        holder.productImage.setImageUrl(url, mImageLoader);
//
//
//        holder.view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i =new Intent(context, shopsActivity.class);
//                i.putExtra("shopId",productData.getId());
//                context.startActivity(i);
//            }
//        });

//        setAnimation(holder.container, position);
    }


    //    private void setAnimation(View viewToAnimate, int position)
//    {
//        // If the bound view wasn't previously displayed on screen, it's animated
//        if (position > lastPosition)
//        {
//            Animation animation = AnimationUtils.loadAnimation(context, android.R.transition.slide_bottom);
//            viewToAnimate.startAnimation(animation);
//            lastPosition = position;
//        }
//    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
