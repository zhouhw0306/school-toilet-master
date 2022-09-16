<template>
  <div class="login-wrap">
    <div class="ms-title">校园坑位管理</div>
    <div class="ms-login">
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        class="demo-ruleForm"
      >
        <el-form-item prop="username">
          <el-input v-model="ruleForm.username" placeholder="username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            type="password"
            placeholder="password"
            v-model="ruleForm.password"
            @keyup.enter.native="submitForm()"
          ></el-input>
        </el-form-item>

        <el-form-item label="验证码" prop="checkCode" label-width="70px" style="margin-bottom: 25px">
          <el-col span="12">
            <el-input
              v-model="ruleForm.checkCode"
              placeholder="请输入验证码"
              clearable
              :style="{ width: '100%' }"
              @keyup.enter.native="submitForm()"
            >
            </el-input>
          </el-col>
          <el-col span="9" style="margin-left: 20px;line-height: 0px">
            <img :src="imgUrl" alt="更换验证码" @click="getVerify()" />
          </el-col>
        </el-form-item>


        <div class="login-btn">
          <el-button type="primary" @click="submitForm">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import {mixin} from '../mixins'
import { getLoginStatus } from '../api/index'

export default {
  mixins: [mixin],
  data: function () {
    return {
      imgUrl: "http://localhost:8888/api/Code/getVerify",
      ruleForm: {
        username: 'admin',
        password: '333',
        checkCode: ''
      },
      rules: {
        username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        checkCode: [{ required: true, message: '请输入密码 ', trigger: 'blur' }]
      }
    }
  },
  methods: {
    submitForm () {
      let params = new URLSearchParams()
      params.append('username', this.ruleForm.username)
      params.append('password', this.ruleForm.password)
      params.append('checkCode', this.ruleForm.checkCode)
      //登录请求
      getLoginStatus(params)
        .then(res => {
          if (res.code === 0) {
            this.$router.push('/Info')
            this.notify('欢迎回来', 'success')
            sessionStorage.setItem("user",JSON.stringify(res.data)) //存储用户信息到浏览器
          } else {
            this.getVerify()
            this.notify(res.msg, 'error')
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
    //获取验证码
    getVerify(){
      this.imgUrl = "http://localhost:8888/api/Code/getVerify?" + Math.random();
    }
  }
}
</script>

<style scoped>
.login-wrap {
  position: relative;
  background: url('../assets/img/background.png');
  background-attachment: fixed;
  background-position: center;
  background-size: cover;
  width: 100%;
  height: 100%;
}
.ms-title {
  position: absolute;
  top: 50%;
  width: 100%;
  margin-top: -230px;
  text-align: center;
  font-size: 30px;
  font-weight: 600;
  color: #fff;
}
.ms-login {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 300px;
  height: 210px;
  margin: -150px 0 0 -190px;
  padding: 40px;
  border-radius: 5px;
  background: #fff;
}
.login-btn {
  text-align: center;
}
.login-btn button {
  width: 100%;
  height: 36px;
}
</style>
