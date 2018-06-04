package blanc.thomas.dawin.tetris.Model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private int[] imageMatrix;

    public GridAdapter(Context context, int[] data) {
        this.context = context;
        this.imageMatrix = data;
    }

    @Override
    public int getCount() {
        return this.imageMatrix.length;
    }

    @Override
    public Object getItem(int position) {
        return this.imageMatrix[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(imageMatrix[position]);
        return imageView;
    }
}
