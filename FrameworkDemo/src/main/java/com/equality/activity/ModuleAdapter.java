package com.equality.activity;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.equality.comm.model.Module;

import java.util.List;

/**
 * Created by neil on 2017/5/14.
 * 模块适配器
 */

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {

    private Context mcontext;
    private List<Module> moduleList;

    public ModuleAdapter(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
       CardView cardView;
       ImageView moduleImage;
       TextView moduleName;

       public ViewHolder(View itemView) {
           super(itemView);
           cardView=(CardView)itemView;
           moduleImage=(ImageView)itemView.findViewById(R.id.module_image);
           moduleName=(TextView)itemView.findViewById(R.id.module_name);
       }
   }

    @Override
    public ModuleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mcontext==null){
            mcontext=parent.getContext();
        }
        View view= LayoutInflater.from(mcontext).inflate(R.layout.module_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Module module=moduleList.get(position);
        holder.moduleName.setText(module.getName());
        holder.moduleImage.setImageResource(module.getImageId());
    }


    @Override
    public int getItemCount() {
        return moduleList.size();
    }



}
