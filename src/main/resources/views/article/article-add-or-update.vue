<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
      <el-form-item label="文章标题" prop="title">
        <el-input v-model="dataForm.title" placeholder="文章标题"></el-input>
      </el-form-item>
      <el-form-item label="文章描述" prop="description">
        <el-input v-model="dataForm.description" placeholder="文章描述"></el-input>
      </el-form-item>
      <el-form-item label="文章作者" prop="author">
        <el-input v-model="dataForm.author" placeholder="文章作者"></el-input>
      </el-form-item>
      <el-form-item label="文章内容" prop="content">
        <el-input v-model="dataForm.content" placeholder="文章内容"></el-input>
      </el-form-item>
      <el-form-item label="html的content" prop="contentFormat">
        <el-input v-model="dataForm.contentFormat" placeholder="html的content"></el-input>
      </el-form-item>
      <el-form-item label="阅读量" prop="readNum">
        <el-input v-model="dataForm.readNum" placeholder="阅读量"></el-input>
      </el-form-item>
      <el-form-item label="评论量" prop="commentNum">
        <el-input v-model="dataForm.commentNum" placeholder="评论量"></el-input>
      </el-form-item>
      <el-form-item label="点赞量" prop="likeNum">
        <el-input v-model="dataForm.likeNum" placeholder="点赞量"></el-input>
      </el-form-item>
      <el-form-item label="文章展示类别,1:普通，2：大图片，3：无图片" prop="coverType">
        <el-input v-model="dataForm.coverType" placeholder="文章展示类别,1:普通，2：大图片，3：无图片"></el-input>
      </el-form-item>
      <el-form-item label="封面" prop="cover">
        <el-input v-model="dataForm.cover" placeholder="封面"></el-input>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
      </el-form-item>
      <el-form-item label="更新时间" prop="updateTime">
        <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
      </el-form-item>
      <el-form-item label="是否推荐文章" prop="recommend">
        <el-input v-model="dataForm.recommend" placeholder="是否推荐文章"></el-input>
      </el-form-item>
      <el-form-item label="分类类别存在多级分类，用逗号隔开" prop="categoryId">
        <el-input v-model="dataForm.categoryId" placeholder="分类类别存在多级分类，用逗号隔开"></el-input>
      </el-form-item>
      <el-form-item label="发布状态" prop="publish">
        <el-input v-model="dataForm.publish" placeholder="发布状态"></el-input>
      </el-form-item>
      <el-form-item label="是否置顶" prop="top">
        <el-input v-model="dataForm.top" placeholder="是否置顶"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()" :disabled="confirmButtonDisabled">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
export default {
  data () {
    return {
      visible: false,
      confirmButtonDisabled: false,
      dataForm: {},
      dataRule: {
        id: [{ required: true, message: '主键不能为空', trigger: 'blur' }],
        title: [{ required: true, message: '文章标题不能为空', trigger: 'blur' }],
        description: [{ required: true, message: '文章描述不能为空', trigger: 'blur' }],
        author: [{ required: true, message: '文章作者不能为空', trigger: 'blur' }],
        content: [{ required: true, message: '文章内容不能为空', trigger: 'blur' }],
        contentFormat: [{ required: true, message: 'html的content不能为空', trigger: 'blur' }],
        readNum: [{ required: true, message: '阅读量不能为空', trigger: 'blur' }],
        commentNum: [{ required: true, message: '评论量不能为空', trigger: 'blur' }],
        likeNum: [{ required: true, message: '点赞量不能为空', trigger: 'blur' }],
        coverType: [{ required: true, message: '文章展示类别,1:普通，2：大图片，3：无图片不能为空', trigger: 'blur' }],
        cover: [{ required: true, message: '封面不能为空', trigger: 'blur' }],
        createTime: [{ required: true, message: '创建时间不能为空', trigger: 'blur' }],
        updateTime: [{ required: true, message: '更新时间不能为空', trigger: 'blur' }],
        recommend: [{ required: true, message: '是否推荐文章不能为空', trigger: 'blur' }],
        categoryId: [{ required: true, message: '分类类别存在多级分类，用逗号隔开不能为空', trigger: 'blur' }],
        publish: [{ required: true, message: '发布状态不能为空', trigger: 'blur' }],
        top: [{ required: true, message: '是否置顶不能为空', trigger: 'blur' }]
      }
    }
  },
  methods: {
    init (id) {
      this.dataForm.id = id || ''
      this.visible = true
      this.confirmButtonDisabled = false
      this.$nextTick(() => {
        this.$refs['dataForm'].resetFields()
        if (this.dataForm.id) {
          this.$http({
            url: this.$http.adornUrl(`/admin/article/article/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 200) {
              this.dataForm = data.article
            }
          })
        } else {
          this.dataForm = {}
        }
      })
    },
    // 表单提交
    dataFormSubmit () {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          this.$http({
            url: this.$http.adornUrl(`/admin/article/article/${!this.dataForm.id ? 'save' : 'update'}`),
            method: !this.dataForm.id ? 'post' : 'put',
            data: this.$http.adornData(this.dataForm)
          }).then(({data}) => {
            this.confirmButtonDisabled = true
            if (data && data.code === 200) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1000,
                onClose: () => {
                  this.visible = false
                  this.$emit('refreshDataList')
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        }
      })
    }
  }
}
</script>
