<template>
  <div class="board-list">
    <div class="common-buttons">
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnWrite">등록</button>
    </div>
    <table class="w3-table-all">
      <thead>
      <tr>
        <th>No</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일시</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(row, id) in list" :key="id">
        <td>{{ row.id }}</td>
        <td><a v-on:click="fnView(`${row.id}`)">{{ row.title }}</a></td>
        <td>{{ row.createBy.nickname }}</td>
        <td>{{ row.createDt }}</td>
      </tr>
      </tbody>
    </table>
    <div class="pagination w3-bar w3-padding-16 w3-small" v-if="paging.totalListCnt > 0">
      <span class="pg">
      <a href="javascript:;" @click="fnPage(1)" class="first w3-button w3-border">&lt;&lt;</a>
      <a href="javascript:;" v-if="paging.startPage > 10" @click="fnPage(`${paging.startPage-1}`)"
         class="prev w3-button w3-border">&lt;</a>
      <template v-for=" (n,index) in paginavigation()">
          <template v-if="paging.page==n">
              <strong class="w3-button w3-border w3-green" :key="index">{{ n }}</strong>
          </template>
          <template v-else>
              <a class="w3-button w3-border" href="javascript:;" @click="fnPage(`${n}`)" :key="index">{{ n }}</a>
          </template>
      </template>
      <a href="javascript:;" v-if="paging.totalPageCnt > paging.endPage"
         @click="fnPage(`${paging.endPage+1}`)" class="next w3-button w3-border">&gt;</a>
      <a href="javascript:;" @click="fnPage(`${paging.totalPageCnt}`)" class="last w3-button w3-border">&gt;&gt;</a>
      </span>
    </div>
  </div>
  <div>
    <select v-model="search_key">
      <option value="">- 선택 -</option>
      <option value="author">작성자</option>
      <option value="title">제목</option>
      <option value="contents">내용</option>
    </select>
    &nbsp;
    <input type="text" v-model="search_value" @keyup.enter="fnGetList()">
    &nbsp;
    <button @click="fnPage()">검색</button>
  </div>
</template>

<script>
export default {
  data() { //변수생성
    return {
      requestBody: {}, //리스트 페이지 데이터전송
      list: {}, //리스트 데이터
      no: '', //게시판 숫자처리
      paging: {
        block: 0,
        endPage: 0,
        nextBlock: 0,
        page: 0,
        pageSize: 0,
        prevBlock: 0,
        startIndex: 0,
        startPage: 0,
        totalBlockCnt: 0,
        totalListCnt: 0,
        totalPageCnt: 0,
      }, //페이징 데이터
      page: this.$route.query.page ? this.$route.query.page : 1,
      size: this.$route.query.size ? this.$route.query.size : 10,
      search_key: this.$route.query.sk ? this.$route.query.sk : '',
      search_value: this.$route.query.sv ? this.$route.query.sv : '',
      paginavigation: function () { //페이징 처리 for문 커스텀
        let pageNumber = [] //;
        let startPage = this.paging.startPage;
        let endPage = this.paging.endPage;
        for (let i = startPage; i <= endPage; i++) pageNumber.push(i);
        return pageNumber;
      }
    }
  },
  mounted() {
    this.fnGetList()
  },
  methods: {
    fnGetList() {
      console.log(this.$route.query.page)
      this.requestBody = { // 데이터 전송
        sk: this.search_key,
        sv: this.search_value,
        page: this.page,
        size: this.size
      }

      this.$axios.get(this.$serverUrl + "/posts", {
        params: this.requestBody
      }).then((res) => {
        console.log(res)
        if (res.data.resultCode === "OK") {
          this.list = res.data.data
          this.paging = res.data.pagination
          this.no = this.paging.totalListCnt - ((this.paging.page - 1) * this.paging.pageSize)
        }

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnView(id) {
      this.requestBody.id = id
      this.$router.push({
        path: './detail',
        query: this.requestBody
      })
    },
    fnWrite() {
      this.$router.push({
        path: './write'
      })
    },
    fnPage(n) {
      if (this.page !== n) {
        this.page = n
        this.fnGetList()
      }
    }
  }
}
</script>