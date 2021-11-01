package com.khabeer.task.app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.Khabeer.task.R
import com.Khabeer.task.databinding.PayrollEmployeeRvItemBinding
import com.khabeer.task.domain.model.EmployeeModel

class EmployeeAdapter(private val employees: List<EmployeeModel>) :
    RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {
    class MyViewHolder(binding: PayrollEmployeeRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding = PayrollEmployeeRvItemBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            PayrollEmployeeRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentEmployee = employees[position]
        holder.binding.name.text = holder.itemView.context.getString(R.string.name,currentEmployee.employeeName)
        holder.binding.sectionName.text = holder.itemView.context.getString(R.string.section_name_s,currentEmployee.sectionName)
        holder.binding.title.text = holder.itemView.context.getString(R.string.job_title_s,currentEmployee.JobTitle)
        holder.binding.marriageStatus.text = holder.itemView.context.getString(R.string.marriage_status_s,currentEmployee.marriageStatus)
        holder.binding.status.text = holder.itemView.context.getString(R.string.status_s,currentEmployee.Status)
    }

    override fun getItemCount(): Int {
        return employees.size
    }
}