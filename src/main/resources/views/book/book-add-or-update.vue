<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
      <el-form-item label="标题" prop="title">
        <el-input v-model="dataForm.title" placeholder="标题"></el-input>
      </el-form-item>
      <el-form-item label="封面" prop="cover">
        <el-input v-model="dataForm.cover" placeholder="封面"></el-input>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input v-model="dataForm.author" placeholder="作者"></el-input>
      </el-form-item>
      <el-form-item label="分类类别" prop="categoryId">
        <el-input v-model="dataForm.categoryId" placeholder="分类类别"></el-input>
      </el-form-item>
      <el-form-item label="是否推荐" prop="recommend">
        <el-input v-model="dataForm.recommend" placeholder="是否推荐"></el-input>
      </el-form-item>
      <el-form-item label="出版社" prop="publisher">
        <el-input v-model="dataForm.publisher" placeholder="出版社"></el-input>
      </el-form-item>
      <el-form-item label="出版日期" prop="publishDate">
        <el-input v-model="dataForm.publishDate" placeholder="出版日期"></el-input>
      </el-form-item>
      <el-form-item label="页数" prop="pageNum">
        <el-input v-model="dataForm.pageNum" placeholder="页数"></el-input>
      </el-form-item>
      <el-form-item label="评分" prop="grade">
        <el-input v-model="dataForm.grade" placeholder="评分"></el-input>
      </el-form-item>
      <el-form-item label="简介" prop="description">
        <el-input v-model="dataForm.description" placeholder="简介"></el-input>
      </el-form-item>
      <el-form-item label="原书目录" prop="catalogue">
        <el-input v-model="dataForm.catalogue" placeholder="原书目录"></el-input>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
      </el-form-item>
      <el-form-item label="更新时间" prop="updateTime">
        <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
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
      <el-form-item label="是否发布" prop="publish">
        <el-input v-model="dataForm.publish" placeholder="是否发布"></el-input>
      </el-form-item>
      <el-form-item label="读书状态" prop="progress">
        <el-input v-model="dataForm.progress" placeholder="读书状态"></el-input>
      </el-form-item>
      <el-form-item label="是否阅读" prop="reading">
        <el-input v-model="dataForm.reading" placeholder="是否阅读"></el-input>
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
        title: [{ required: true, message: '标题不能为空', trigger: 'blur' }],
        cover: [{ required: true, message: '封面不能为空', trigger: 'blur' }],
        author: [{ required: true, message: '作者不能为空', trigger: 'blur' }],
        categoryId: [{ required: true, message: '分类类别不能为空', trigger: 'blur' }],
        recommend: [{ required: true, message: '是否推荐不能为空', trigger: 'blur' }],
        publisher: [{ required: true, message: '出版社不能为空', trigger: 'blur' }],
        publishDate: [{ required: true, message: '出版日期不能为空', trigger: 'blur' }],
        pageNum: [{ required: true, message: '页数不能为空', trigger: 'blur' }],
        grade: [{ required: true, message: '评分不能为空', trigger: 'blur' }],
        description: [{ required: true, message: '简介不能为空', trigger: 'blur' }],
        catalogue: [{ required: true, message: '原书目录不能为空', trigger: 'blur' }],
        createTime: [{ required: true, message: '创建时间不能为空', trigger: 'blur' }],
        updateTime: [{ required: true, message: '更新时间不能为空', trigger: 'blur' }],
        readNum: [{ required: true, message: '阅读量不能为空', trigger: 'blur' }],
        commentNum: [{ required: true, message: '评论量不能为空', trigger: 'blur' }],
        likeNum: [{ required: true, message: '点赞量不能为空', trigger: 'blur' }],
        publish: [{ required: true, message: '是否发布不能为空', trigger: 'blur' }],
        progress: [{ required: true, message: '读书状态不能为空', trigger: 'blur' }],
        reading: [{ required: true, message: '是否阅读不能为空', trigger: 'blur' }]
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
            url: this.$http.adornUrl(`/admin/book/book/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 200) {
              this.dataForm = data.book
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
            url: this.$http.adornUrl(`/admin/book/book/${!this.dataForm.id ? 'save' : 'update'}`),
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
