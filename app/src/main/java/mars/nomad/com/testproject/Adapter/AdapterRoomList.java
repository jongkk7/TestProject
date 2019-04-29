package mars.nomad.com.testproject.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import mars.nomad.com.testproject.DataModel.RoomDataModel;
import mars.nomad.com.testproject.R;
import mars.nomad.com.testproject.Util.ErrorController;
import mars.nomad.com.testproject.Util.SingleObjectCallback;

public class AdapterRoomList extends RecyclerView.Adapter<AdapterRoomList.ViewHolderGyoJuct> {

    private Context context;
    private List<RoomDataModel> data;
    private SingleObjectCallback<RoomDataModel> callback;

    public AdapterRoomList(Context context, List<RoomDataModel> list, SingleObjectCallback<RoomDataModel> callback) {
        this.context = context;
        this.data = list;
        this.callback = callback;
    }

    @Override
    public ViewHolderGyoJuct onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_room_list, parent, false);
        return new ViewHolderGyoJuct(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderGyoJuct holder, int position) {

        try{

            RoomDataModel item = data.get(position);

            holder.textViewTitle.setText(item.getTitle());

            holder.textViewStartTime.setText(item.getStart_time());

        }catch (Exception e){
            ErrorController.showError(e);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    /**
     * 아이템 홀더
     * 귀찮아서 대강만듬
     */
    public class ViewHolderGyoJuct extends RecyclerView.ViewHolder {

        private LinearLayout linearLayoutCell;
        private TextView textViewTitle;
        private TextView textViewStartTime;

        public ViewHolderGyoJuct(View itemView) {
            super(itemView);
            linearLayoutCell = (LinearLayout) itemView.findViewById(R.id.linearLayoutCell);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewStartTime = (TextView) itemView.findViewById(R.id.textViewStartTime);

            linearLayoutCell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onSuccess(data.get(getAdapterPosition()));
                }
            });
        }
    }
}
