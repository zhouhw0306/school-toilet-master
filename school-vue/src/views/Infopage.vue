<template>
  <div>
    <el-form
      ref="form"
      :model="form"
      label-width="80px"
      size="mini"
      :inline="true"
    >
      <el-form-item label="类型">
        <el-select
          v-model="form.type"
          placeholder="请选择类型"
          style="width: 100px"
        >
          <el-option label="全部" value=""></el-option>
          <el-option label="小便池" value="1"></el-option>
          <el-option label="蹲坑" value="2"></el-option>
          <el-option label="马桶" value="3"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="大楼">
        <el-select
          v-model="form.placeNo"
          placeholder="请选择大楼"
          style="width: 100px"
        >
          <el-option label="全部" value=""></el-option>
          <el-option label="启德楼" value="1"></el-option>
          <el-option label="爱心楼" value="2"></el-option>
          <el-option label="逸夫楼" value="3"></el-option>
          <el-option label="致远楼" value="4"></el-option>
          <el-option label="沁华楼" value="5"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="男/女">
        <el-select
          v-model="form.sex"
          placeholder="请选择性别"
          style="width: 100px"
        >
          <el-option label="全部" value=""></el-option>
          <el-option label="男" value="1"></el-option>
          <el-option label="女" value="0"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="优先无人">
        <el-switch v-model="form.status"></el-switch>
      </el-form-item>
      <el-button
        type="primary"
        size="mini"
        icon="el-icon-search"
        @click="loadTable"
        >搜索</el-button
      >
    </el-form>

    <div style="margin: 10px 0">
      <el-button type="primary" size="small" @click="handleAdd"
        >新增<i class="el-icon-plus"></i
      ></el-button>
      <el-button type="success" size="small"
        >导入<i class="el-icon-bottom"></i
      ></el-button>
      <el-button type="warning" size="small" @click="exportTable"
        >导出<i class="el-icon-top"></i
      ></el-button>
    </div>

    <el-dialog :title="title" :visible.sync="dialogFormVisible" width="30%">
      <el-form v-model="tableOne">
        <el-form-item label="性别" :label-width="formLabelWidth">
          <el-select v-model="tableOne.sex" placeholder="请选择性别">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="类型" :label-width="formLabelWidth">
          <el-select v-model="tableOne.type" placeholder="请选择类型">
            <el-option label="小便池" value="小便池"></el-option>
            <el-option label="蹲坑" value="蹲坑"></el-option>
            <el-option label="马桶" value="马桶"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="大楼" :label-width="formLabelWidth">
          <el-select v-model="tableOne.placeNo" placeholder="请选择大楼">
            <el-option label="启德楼" value="启德楼"></el-option>
            <el-option label="爱心楼" value="爱心楼"></el-option>
            <el-option label="逸夫楼" value="逸夫楼"></el-option>
            <el-option label="致远楼" value="致远楼"></el-option>
            <el-option label="沁华楼" value="沁华楼"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="详细地址" :label-width="formLabelWidth">
          <el-input
            v-model="tableOne.placeDetail"
            autocomplete="off"
          ></el-input>
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitform">确 定</el-button>
      </div>
    </el-dialog>

    <el-table
      v-loading="loading"
      element-loading-text="拼命加载中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.8)"
      :data="tableData"
      style="width: 100%"
      height="450"
      :row-class-name="tableRowClassName"
    >
      <el-table-column label="类型" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">
            <el-tag v-if="scope.row.type === '小便池'">{{
              scope.row.type
            }}</el-tag>
            <el-tag v-if="scope.row.type === '蹲坑'" type="success">{{
              scope.row.type
            }}</el-tag>
            <el-tag v-if="scope.row.type === '马桶'" type="warning">{{
              scope.row.type
            }}</el-tag>
          </span>
        </template>
      </el-table-column>
      <el-table-column prop="sex" label="性别" width="120">
        <template slot-scope="scope">
          <i
            v-if="scope.row.sex === '男'"
            class="el-icon-male"
            style="color: blue"
          ></i>
          <i
            v-if="scope.row.sex === '女'"
            class="el-icon-female"
            style="color: red"
          ></i>
          <span>{{ scope.row.sex }}</span>
        </template>
      </el-table-column>

      <el-table-column prop="placeDetail" label="位置" width="250">
        <template slot-scope="scope">
          <i class="el-icon-location-information" style="color: #409eff"></i>
          <span>{{ scope.row.placeDetail }}</span>
        </template>
      </el-table-column>

      <el-table-column prop="status" label="状态" width="150">
        <template slot-scope="scope">
          <i
            v-if="scope.row.status === '无人'"
            class="el-icon-user-solid"
            style="color: #67c23a"
          ></i>
          <i
            v-if="scope.row.status === '有人'"
            class="el-icon-user-solid"
            style="color: #409eff"
          ></i>
          <i
            v-if="scope.row.status === '维修中'"
            class="el-icon-s-tools"
            style="color: #f56c6c"
          ></i>
          <span>{{ scope.row.status }}</span>
        </template>
      </el-table-column>

      <el-table-column prop="health" label="卫生状况" width="150">
        <template slot-scope="scope">
          <i
            v-if="scope.row.health === '干净'"
            class="el-icon-s-flag"
            style="color: #67c23a"
          ></i>
          <i
            v-if="scope.row.health === '一般'"
            class="el-icon-s-flag"
            style="color: #409eff"
          ></i>
          <i
            v-if="scope.row.health === '肮脏'"
            class="el-icon-s-flag"
            style="color: #f56c6c"
          ></i>
          <span>{{ scope.row.health }}</span>
        </template>
      </el-table-column>

      <el-table-column prop="cleanTime" label="上次清洁时间" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span>{{ scope.row.cleanTime }}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pageNo"
      :page-sizes="[5, 10, 15, 20]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
  </div>
</template>

<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>

<script>
import axios from "axios";
import {
  getTableData,
  deleteById,
  updateOrAdd,
} from "../api/index";

export default {
  methods: {
    tableRowClassName({ row, rowIndex }) {
      if (rowIndex === 1) {
        return "warning-row";
      } else if (rowIndex === 3) {
        return "success-row";
      }
      return "";
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.loadTable();
    },
    handleCurrentChange(val) {
      this.pageNo = val;
      this.loadTable();
    },
    loadTable() {
      this.loading = true;
      let params = new URLSearchParams();
      params.append("type", this.form.type);
      params.append("placeNo", this.form.placeNo);
      params.append("sex", this.form.sex);
      params.append("status", this.form.status);
      params.append("pageNo", this.pageNo);
      params.append("pageSize", this.pageSize);
      getTableData(params)
        .then((res) => {
          this.tableData = res.records;
          this.total = res.total;
          this.loading = false;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //删除
    handleDelete(id) {
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true,
      })
        .then(() => {
          let params = new URLSearchParams();
          params.append("id", id);
          deleteById(params)
            .then((res) => {
              if (res.code === 0) {
                this.$message({
                  type: "success",
                  message: "删除成功!",
                });
                this.loadTable();
              } else {
                this.$message.error("删除失败");
              }
            })
            .catch((err) => {
              this.$message.error(err);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    handleEdit(row) {
      (this.dialogFormVisible = true), (this.title = "编辑");
      this.tableOne = JSON.parse(JSON.stringify(row));
    },
    handleAdd() {
      this.tableOne = { sex: "", type: "", placeNo: "", placeDetail: "" };
      (this.dialogFormVisible = true), (this.title = "新增");
    },
    //更新or删除
    submitform() {
      updateOrAdd(this.tableOne)
        .then((res) => {
          if (res.code === 0) {
            this.$message.success(this.title + "成功");
            this.dialogFormVisible = false;
            this.tableOne = "";
            this.loadTable();
          } else {
            this.$message.error(this.title + "失败");
            this.dialogFormVisible = false;
            this.tableOne = "";
            this.loadTable();
          }
        })
        .catch((err) => {
          this.$message.error(err);
        });
    },
    //导出
    exportTable() {
      axios({
        method: "GET",
        url: "/api/toilet/export",
        responseType: "blob",
      })
        .then((res) => {
          let blob = new Blob([res.data], {
            type: "text/csv,charset=UTF-8,\uFEFF",
          });
          let url = window.URL.createObjectURL(blob);
          let link = document.createElement("a");
          link.href = window.URL.createObjectURL(blob);
          link.download = "坑位信息表.xlsx";
          link.click();
          this.$message.success("导出成功");
        })
        .catch((err) => {
          console.log(err);
          this.$message.error("导出失败");
        });
    },
  },
  created() {
    this.loadTable();
  },
  data() {
    return {
      tableData: [],
      loading: false,
      form: {
        type: "",
        placeNo: "",
        sex: "",
        status: false,
      },
      pageNo: 1,
      pageSize: 5,
      total: 0,
      dialogFormVisible: false,
      title: "",
      tableOne: "",
    };
  },
};
</script>
