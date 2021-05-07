<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-container>

    <el-main class="main" :style="this.$store.state.background" style="overflow: hidden;padding: 0%">
       <div><lo></lo></div>

      <div class="OASIS" style="font-weight: bold ;color:white;font-size: 130px;text-align:center;margin-top: 7%">
            CCF ANALYZER
      </div>

      <div class="_radio" style="text-align: center;margin-top: -8px">
        <el-radio-group v-model="searchRadio" style="opacity: 80%" size="medium">
          <el-radio-button label= '1'>Common   Search</el-radio-button>
          <el-radio-button label= '2'>Advanced Search</el-radio-button>
        </el-radio-group>
      </div>

      <!--普通搜索-->
      <div style="text-align: center;" v-if="searchRadio==='1'">

        <el-select v-model="commonSearchTypeValue" clearable placeholder="All"  style="opacity:80%; width: 10%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" >
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>

      </el-select>
        <el-input
          v-if="commonSearchTypeValue === ''||commonSearchTypeValue === 'keyword'"
          class="common_input"
          style="opacity:80%;width:40%;margin-top: 4%"
          placeholder="Enter something..."
          v-model="commonInput"
          :disabled="searching"
          @keyup.enter.native="commonSearch"
          clearable>
        </el-input>
        <el-autocomplete v-if="commonSearchTypeValue === 'author'"
          :minlength="2" style="opacity:80%;width:40%;margin-top: 4%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" v-model="searchAuthor.name" :fetch-suggestions="querySearchAsync" placeholder="Enter something..."
                         @select="handleSelect"></el-autocomplete>
        <el-autocomplete v-if="commonSearchTypeValue === 'affiliation'"
                         :minlength="2" style="opacity:80%;width:40%;margin-top: 4%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" v-model="searchAffiliation.name" :fetch-suggestions="querySearchAsync2" placeholder="Enter something..."
                         @select="handleSelect2"></el-autocomplete>

        <el-button @click="commonSearch" type="primary" icon="el-icon-search" :loading="searching">SEARCH</el-button>

      </div>

      <!--高级搜索-->
      <div v-else>
        <!--第一行固定选框-->
        <div style="text-align: center;">
          <el-row>
            <el-col :span="12" style="text-align: center;">
              <el-select style="opacity:80%;width: 45%;margin-top: 6%; margin-left: 45%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" v-model="firstType" clearable placeholder="TYPE">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-col>
            <el-col :span="6">
              <el-input  v-if="firstType === ''||firstType==='keyword'"style="opacity:80%;width: 80%;margin-top: 12%;" placeholder="Enter something..."
                         v-model="firstInput"
                         @keyup.enter.native="advancedSearch"
                         clearable></el-input>
              <el-autocomplete v-if="firstType === 'author'"
                               :minlength="2" style="opacity:80%;width: 80%;margin-top: 12%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" v-model="searchAuthor.name" :fetch-suggestions="querySearchAsync" placeholder="Enter something..."
                               @select="handleSelect"></el-autocomplete>
              <el-autocomplete v-if="firstType === 'affiliation'"
                               :minlength="2" style="opacity:80%;width: 80%;margin-top: 12%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" v-model="searchAffiliation.name" :fetch-suggestions="querySearchAsync2" placeholder="Enter something..."
                               @select="handleSelect2"></el-autocomplete>
            </el-col>
            <el-col :span="6" style="text-align: left">
              <el-button v-show="searchCount===1" @click="addSearchBox(-1)" style="margin-top: 12%;" type="primary" icon="el-icon-plus" circle></el-button>
            </el-col>

          </el-row>

        </div>

        <!--可变选框-->
        <div style="text-align: center;" v-for="(sc_item, index) in searchContexts" v-bind:key="index">
          <el-row v-show="sc_item.isShow">
            <el-col :span="12" style="text-align: center;">
              <el-select style="opacity:80%;width: 45%; margin-left: 45%;text-align: left;position:relative;" :style="99-index":popper-append-to-body="false" v-model="sc_item.type" clearable placeholder="TYPE">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-col>
            <el-col :span="6">
              <el-input  v-if="sc_item.type === ''||sc_item.type==='keyword'"style="opacity:80%;width: 80%;text-align: left;position:relative; ":style="99-index"  :popper-append-to-body="false"placeholder="Enter something..."
                         v-model="sc_item.value"
                         @keyup.enter.native="advancedSearch"
                         clearable></el-input>
              <el-autocomplete v-if="sc_item.type === 'author'"
                               :minlength="2" style="opacity:80%;width: 80%;text-align: left;position:relative; " :style="99-index" :popper-append-to-body="false" v-model="sc_item.value" :fetch-suggestions="querySearchAsync" placeholder="Enter something..."
                               @select="handleSelect"></el-autocomplete>
              <el-autocomplete v-if="sc_item.type === 'affiliation'"
                               :minlength="2" style="opacity:80%;width: 80%;text-align: left;position:relative; " :style="99-index" :popper-append-to-body="false" v-model="sc_item.value" :fetch-suggestions="querySearchAsync2" placeholder="Enter something..."
                               @select="handleSelect2"></el-autocomplete>
            </el-col>
            <el-col :span="6" style="text-align: left">
              <el-button @click="deleteSearchBox(index)" type="primary" icon="el-icon-minus" circle></el-button>
              <el-button v-show="sc_item.isLastOne && (index !== (searchContexts.length - 1))" @click="addSearchBox(index)" type="primary" icon="el-icon-plus" circle></el-button>
            </el-col>

          </el-row>

        </div>
<br><br><br>
        <!--年份和ise/icse选框-->
        <div style="text-align: center;">
          <el-row>

            <el-col :span="12">
              <el-slider
                style="width: 40%;margin-left: 50%"
                v-model="value_year"
                range
                show-stops
                :min="2010"
                :max="2020">
              </el-slider>

            </el-col>
            <el-col :span="12" style="text-align: center;">
              <el-autocomplete :minlength="2" style="opacity:80%;width: 40%;margin-right:50%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" v-model="searchConference" :fetch-suggestions="querySearchAsync3" placeholder="Enter something..."
                               @select="handleSelect3"></el-autocomplete>
            </el-col>

          </el-row>

        </div>
        <!--高级search按钮-->
        <br>
        <el-row style="text-align: right;margin-right: 27%">
          <el-button @click="advancedSearch" type="primary" icon="el-icon-search" :loading="searching_advanced">SEARCH</el-button>
        </el-row>

      </div>

      <!--统计数据-->
      <div style="margin-left: -19px;margin-right: -19px;text-align: justify">
        <el-row style="margin-top: 8%;margin-bottom: -8%">
          <el-col :span="6">
            <div class="grid-content bg-purple" style="color: white">

              <el-row style="margin-bottom: -8%">
                <el-col :span="8">
                  <div class="grid-content">
                    <Icon class="header_icon" type="md-school" size="50"/>
                  </div>
                </el-col>
                <el-col :span="16">
                  <div class="grid-content">
                    <div class="header_num">{{statisticsNums.authorNum}}</div>
                    <div class="header_type">Authors</div>
                  </div>
                </el-col>
              </el-row>

            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple" style="color: white;">

              <el-row style="margin-bottom: -8%">
                <el-col :span="8">
                  <div class="grid-content">
                    <Icon class="header_icon" type="md-document" size="50"/>
                  </div>
                </el-col>
                <el-col :span="16">
                  <div class="grid-content">
                    <div class="header_num">{{statisticsNums.paperNum}}</div>
                    <div class="header_type">Papers</div>
                  </div>
                </el-col>
              </el-row>

            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple" style="color: white;">

              <el-row style="margin-bottom: -8%">
                <el-col :span="8">
                  <div class="grid-content">
                    <Icon class="header_icon" type="md-home" size="50"/>
                  </div>
                </el-col>
                <el-col :span="16">
                  <div class="grid-content">
                    <div class="header_num">{{statisticsNums.affiliationNum}}</div>
                    <div class="header_type">Affiliation</div>
                  </div>
                </el-col>
              </el-row>

            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple" style="color: white;">

              <el-row style="margin-bottom: -8%">
                <el-col :span="8">
                  <div class="grid-content">
                    <Icon class="header_icon" type="ios-book" size="50"/>
                  </div>
                </el-col>
                <el-col :span="16">
                  <div class="grid-content">
                    <div class="header_num">{{statisticsNums.allArticleCitationCount}}</div>
                    <div class="header_type">Citiation</div>
                  </div>
                </el-col>
              </el-row>

            </div>
          </el-col>
        </el-row>
      </div>

    </el-main>

    <!--<el-footer>-->
      <!--<el-row :gutter="80" style="margin-left: 2%;margin-right: 2%">-->

        <!--<el-col :span="8">-->
          <!--<div class="ranking_1 grid-content" style="margin-top: 50px">-->

            <!--<el-card class="box-card">-->
              <!--<div slot="header" class="clearfix head_card">-->
                <!--<span style="font-size: 24px;font-weight: bold">-->
                  <!--<Icon type="ios-home" style="color: cornflowerblue;margin-left: 2%" size = "40" />-->
                  <!--Most Published Affiliations-->
                <!--</span>-->
              <!--</div>-->
              <!--<div>-->
                <!--<el-row style="font-size: 24px">-->
                  <!--<el-col :span="12" style="text-align: left">Name</el-col>-->
                  <!--<el-col :span="12" style="text-align: right">Article Num</el-col>-->
                <!--</el-row>-->
              <!--</div>-->
              <!--<div v-for="item in topAffiliationList" :key="item.affiliationId" class="text item">-->
                <!--&lt;!&ndash;{{'列表内容 ' + o }}&ndash;&gt;-->
                <!--<el-row style="font-size: 18px">-->
                  <!--<el-col :span="20" style="text-align: left">-->
                    <!--<el-tooltip effect="dark" placement="right">-->
                      <!--<div slot="content">-->
                        <!--{{item.name}}-->
                      <!--</div>-->
                      <!--<router-link target="_blank" :to="{name:'AffiliationPortrait',query:{affiliationId:item.affiliationId}}">-->
                        <!--&lt;!&ndash;<el-link style="transition-duration: 0.4s;">&ndash;&gt;-->
                        <!--<div style="font-size: 18px;color: cornflowerblue; overflow: hidden;-->
                       <!--white-space: nowrap;width: 300px;text-overflow: ellipsis;">-->
                          <!--{{item.name}}-->
                        <!--</div>-->
                        <!--&lt;!&ndash;</el-link>&ndash;&gt;-->
                      <!--</router-link>-->
                    <!--</el-tooltip>-->
                  <!--</el-col>-->
                  <!--<el-col :span="4" style="text-align: right">{{item.articleNum}}</el-col>-->
                <!--</el-row>-->
                <!--<div style="margin-top: -20px">-->
                  <!--<Progress :percent="100*item.articleNum/articleNumMost_affiliation" :stroke-color="['#108ee9', '#87d068']" hide-info/>-->
                <!--</div>-->

              <!--</div>-->
            <!--</el-card>-->

          <!--</div>-->
        <!--</el-col>-->

        <!--&lt;!&ndash;获得参与发表论文次数最多的作者TOP10&ndash;&gt;-->
        <!--<el-col :span="8">-->
          <!--<div class="ranking_1 grid-content" style="margin-top: 50px">-->

            <!--<el-card class="box-card">-->
              <!--<div slot="header" class="clearfix head_card">-->
                <!--<span style="font-size: 24px;font-weight: bold">-->
                  <!--<Icon type="md-person" style="color: cornflowerblue;margin-left: 10%" size = "40" />-->
                  <!--Most Published Authors-->
                <!--</span>-->
              <!--</div>-->
              <!--<div>-->
                <!--<el-row style="font-size: 24px">-->
                  <!--<el-col :span="12" style="text-align: left">Name</el-col>-->
                  <!--<el-col :span="12" style="text-align: right">Article Num</el-col>-->
                <!--</el-row>-->
              <!--</div>-->
              <!--<div v-for="item in topAuthorList" :key="item.paperId" class="text item">-->
                <!--&lt;!&ndash;{{'列表内容 ' + o }}&ndash;&gt;-->
                <!--<el-row style="font-size: 18px">-->
                  <!--<el-col :span="20" style="text-align: left">-->
                    <!--<el-tooltip effect="dark" placement="right">-->
                      <!--<div slot="content">-->
                        <!--{{item.name}}-->
                      <!--</div>-->
                      <!--<router-link target="_blank" :to="{name:'AuthorPortrait',query:{authorId:item.authorId}}">-->
                        <!--&lt;!&ndash;<el-link style="transition-duration: 0.4s;">&ndash;&gt;-->
                        <!--<div style="font-size: 18px;color: cornflowerblue; overflow: hidden;-->
                       <!--white-space: nowrap;width: 300px;text-overflow: ellipsis;">-->
                          <!--{{item.name}}-->
                        <!--</div>-->
                        <!--&lt;!&ndash;</el-link>&ndash;&gt;-->
                      <!--</router-link>-->
                    <!--</el-tooltip>-->
                  <!--</el-col>-->
                  <!--<el-col :span="4" style="text-align: right">{{item.articleNum}}</el-col>-->
                <!--</el-row>-->
                <!--<div style="margin-top: -20px">-->
                  <!--<Progress :percent="100*item.articleNum/articleNumMost_author" :stroke-color="['#108ee9', '#87d068']" hide-info/>-->
                <!--</div>-->

              <!--</div>-->
            <!--</el-card>-->

          <!--</div>-->
        <!--</el-col>-->

        <!--&lt;!&ndash;被引用次数最多论文TOP10&ndash;&gt;-->
        <!--<el-col :span="8">-->
          <!--<div class="ranking_1 grid-content" style="margin-top: 50px">-->

            <!--<el-card class="box-card">-->
              <!--<div slot="header" class="clearfix head_card">-->
                <!--<span style="font-size: 24px;font-weight: bold">-->
                  <!--<Icon type="ios-paper" style="color: cornflowerblue;margin-left: 18%" size = "40" />-->
                   <!--Popular Papers-->
                <!--</span>-->
              <!--</div>-->
              <!--<div>-->
                <!--<el-row style="font-size: 24px">-->
                  <!--<el-col :span="12" style="text-align: left">Paper</el-col>-->
                  <!--<el-col :span="12" style="text-align: right">Times Cited</el-col>-->
                <!--</el-row>-->
              <!--</div>-->
              <!--<div v-for="item in topPaperList" :key="item.paperId" class="text item">-->
                <!--&lt;!&ndash;{{'列表内容 ' + o }}&ndash;&gt;-->
                <!--<el-row style="font-size: 18px">-->
                  <!--<el-col :span="20" style="text-align: left">-->
                    <!--<el-tooltip effect="dark" placement="left">-->
                      <!--<div slot="content">-->
                        <!--{{item.title}}-->
                      <!--</div>-->
                      <!--<router-link target="_blank" :to="{name:'PaperDetail',query:{paperId:item.paperId}}">-->
                        <!--&lt;!&ndash;<el-link style="transition-duration: 0.4s;">&ndash;&gt;-->
                        <!--<div style="font-size: 18px;color: cornflowerblue; overflow: hidden;-->
                       <!--white-space: nowrap;width: 300px;text-overflow: ellipsis;">-->
                          <!--{{item.title}}-->
                        <!--</div>-->
                        <!--&lt;!&ndash;</el-link>&ndash;&gt;-->
                      <!--</router-link>-->
                    <!--</el-tooltip>-->
                  <!--</el-col>-->
                  <!--<el-col :span="4" style="text-align: right">{{item.articleCitationCount}}</el-col>-->
                <!--</el-row>-->
                <!--<div style="margin-top: -20px">-->
                  <!--<Progress :percent="100*item.articleCitationCount/timedCitedMost" :stroke-color="['#108ee9', '#87d068']" hide-info/>-->
                <!--</div>-->

              <!--</div>-->
            <!--</el-card>-->

          <!--</div>-->
        <!--</el-col>-->

      <!--</el-row>-->

      <!--<div style="margin-top: 5%; margin-bottom: 5%; margin-left: 5%; margin-right: 5%"><el-divider></el-divider></div>-->

      <!--&lt;!&ndash;迭代二活跃度排行&ndash;&gt;-->
      <!--<div class="ranking_2">-->
        <!--<el-row :gutter="80" style="margin-left: 2%;margin-right: 2%">-->

          <!--&lt;!&ndash;机构活跃度排行&ndash;&gt;-->
          <!--<el-col :span="8">-->
            <!--<el-card class="box-card">-->
              <!--<div slot="header" class="clearfix head_card" style=";text-align: center;background-color: #A6BAC9">-->
                <!--<span style="font-size: 23px;font-weight: bold">-->
                  <!--&lt;!&ndash;<Icon type="md-person" style="color: cornflowerblue;margin-left: 18%" size = "40" />&ndash;&gt;-->
                  <!--{{ranking2s[0].title}}-->
                <!--</span>-->
              <!--</div>-->
              <!--<div v-for="(item, index) in ranking2s[0].contents5" :key="item.id" class="text item">-->
                <!--&lt;!&ndash;{{'列表内容 ' + o }}&ndash;&gt;-->
                <!--<el-row style="font-size: 18px">-->
                  <!--<el-col :span="20" style="text-align: left">-->
                    <!--<el-tooltip effect="dark" placement="right">-->
                      <!--<div slot="content">-->
                        <!--Activity: {{toPercent(item.activeness)}}, {{item.name}}-->
                      <!--</div>-->
                      <!--<router-link target="_blank" :to="{name:'AffiliationPortrait',query:{affiliationId:item.affiliationId}}">-->
                          <!--<div style="font-size: 18px; overflow: hidden; color: #000000;-->
                       <!--white-space: nowrap;width: 320px;text-overflow: ellipsis;">-->
                            <!--<span style="color: darkgray; font-weight: bold; font-style: italic">{{index + 1}}.</span>&nbsp;&nbsp;-->
                            <!--<span style="font-weight: bold; color: #383838">{{item.name}}</span>-->
                          <!--</div>-->
                      <!--</router-link>-->
                    <!--</el-tooltip>-->
                  <!--</el-col>-->
                  <!--<el-col :span="4" style="text-align: right;">-->
                    <!--<router-link target="_blank" :to="{name:'AffiliationPortrait',query:{affiliationId:item.affiliationId}}" style="color: darkgray">-->
                      <!--<i class="el-icon-arrow-right"></i>-->
                    <!--</router-link>-->
                  <!--</el-col>-->
                <!--</el-row>-->

              <!--</div>-->
            <!--</el-card>-->
          <!--</el-col>-->

          <!--&lt;!&ndash;作者活跃度排行&ndash;&gt;-->
          <!--<el-col :span="8">-->
            <!--<el-card class="box-card">-->
              <!--<div slot="header" class="clearfix head_card" style=";text-align: center;background-color: #E6CBCB">-->
                <!--<span style="font-size: 23px;font-weight: bold">-->
                  <!--&lt;!&ndash;<Icon type="md-person" style="color: cornflowerblue;margin-left: 18%" size = "40" />&ndash;&gt;-->
                  <!--{{ranking2s[1].title}}-->
                <!--</span>-->
              <!--</div>-->
              <!--<div v-for="(item, index) in ranking2s[1].contents5" :key="item.id" class="text item">-->
                <!--&lt;!&ndash;{{'列表内容 ' + o }}&ndash;&gt;-->
                <!--<el-row style="font-size: 18px">-->
                  <!--<el-col :span="20" style="text-align: left">-->
                    <!--<el-tooltip effect="dark" placement="right">-->
                      <!--<div slot="content">-->
                        <!--Activity: {{toPercent(item.activeness)}}, {{item.name}}-->
                      <!--</div>-->
                      <!--<router-link target="_blank" :to="{name:'AuthorPortrait',query:{authorId:item.authorId}}">-->
                        <!--<div style="font-size: 18px; overflow: hidden; color: #000000;-->
                       <!--white-space: nowrap;width: 320px;text-overflow: ellipsis;">-->
                          <!--<span style="color: darkgray; font-weight: bold; font-style: italic">{{index + 1}}.</span>&nbsp;&nbsp;-->
                          <!--<span style="font-weight: bold; color: #383838">{{item.name}}</span>-->
                        <!--</div>-->
                      <!--</router-link>-->
                    <!--</el-tooltip>-->
                  <!--</el-col>-->
                  <!--<el-col :span="4" style="text-align: right;">-->
                    <!--<router-link target="_blank" :to="{name:'AffiliationPortrait',query:{affiliationId:item.affiliationId}}" style="color: darkgray">-->
                      <!--<i class="el-icon-arrow-right"></i>-->
                    <!--</router-link>-->
                  <!--</el-col>-->
                <!--</el-row>-->
              <!--</div>-->
            <!--</el-card>-->
          <!--</el-col>-->

          <!--&lt;!&ndash;研究方向热度排行&ndash;&gt;-->
          <!--<el-col :span="8">-->
            <!--<el-card class="box-card">-->
              <!--<div slot="header" class="clearfix head_card" style=";text-align: center;background-color: #B7E0C3">-->
                <!--<span style="font-size: 23px;font-weight: bold">-->
                  <!--&lt;!&ndash;<Icon type="md-person" style="color: cornflowerblue;margin-left: 18%" size = "40" />&ndash;&gt;-->
                  <!--{{ranking2s[2].title}}-->
                <!--</span>-->
              <!--</div>-->
              <!--<div v-for="(item, index) in ranking2s[2].contents5" :key="item.id" class="text item">-->
                <!--&lt;!&ndash;{{'列表内容 ' + o }}&ndash;&gt;-->
                <!--<el-row style="font-size: 18px">-->
                  <!--<el-col :span="20" style="text-align: left">-->
                    <!--<el-tooltip effect="dark" placement="right">-->
                      <!--<div slot="content">-->
                        <!--Popularity: {{toPercent(item.activeness)}}, {{item.name}}-->
                      <!--</div>-->
                      <!--<router-link target="_blank" :to="{name:'DirectionPortrait',query:{directionId:item.researchDirectionId}}">-->
                        <!--<div style="font-size: 18px; overflow: hidden; color: #000000;-->
                       <!--white-space: nowrap;width: 320px;text-overflow: ellipsis;">-->
                          <!--<span style="color: darkgray; font-weight: bold; font-style: italic">{{index + 1}}.</span>&nbsp;&nbsp;-->
                          <!--<span style="font-weight: bold; color: #383838">{{item.name}}</span>-->
                        <!--</div>-->
                      <!--</router-link>-->
                    <!--</el-tooltip>-->
                  <!--</el-col>-->
                  <!--<el-col :span="4" style="text-align: right;">-->
                    <!--<router-link target="_blank" :to="{name:'AffiliationPortrait',query:{affiliationId:item.affiliationId}}" style="color: darkgray">-->
                      <!--<i class="el-icon-arrow-right"></i>-->
                    <!--</router-link>-->
                  <!--</el-col>-->
                <!--</el-row>-->

              <!--</div>-->
            <!--</el-card>-->
          <!--</el-col>-->

        <!--</el-row>-->
      <!--</div>-->

      <!--<div style="margin-top: 7%; margin-bottom: 7%;  margin-left: 5%; margin-right: 5%">-->
        <!--<el-divider content-position="center" >WHAT'S NEW</el-divider>-->
      <!--</div>-->

      <!--&lt;!&ndash;迭代二兴趣点列表&ndash;&gt;-->
      <!--<div class="whats_funny">-->
        <!--<el-row :gutter="40" style="margin-left: 2%;margin-right: 2%">-->

          <!--<el-col :span="6">-->
            <!--<el-card class="funny_card" :body-style="{ padding: '0px' }">-->
              <!--<router-link :to="{name:'PaperDetail',query:{tab: 'tab1'}}">-->
                <!--<img :src="funnyList[0].picture" class="image">-->
              <!--</router-link>-->

              <!--<div style="padding: 20px;text-align: center">-->
                <!--<router-link :to="{name:'PaperDetail',query:{tab: 'tab1'}}">-->
                  <!--<el-link style="transition-duration: 0.4s;">-->
                    <!--<div style="font-size: 24px;color: #000000; overflow: hidden;-->
                         <!--white-space: nowrap;text-overflow: ellipsis;">-->
                      <!--{{funnyList[0].title}}-->
                    <!--</div>-->
                  <!--</el-link>-->
                <!--</router-link>-->
              <!--</div>-->

            <!--</el-card>-->
          <!--</el-col>-->

          <!--<el-col :span="6">-->
            <!--<el-card class="funny_card" :body-style="{ padding: '0px' }">-->
              <!--<router-link :to="{name:'PaperDetail',query:{tab: 'tab2'}}">-->
                <!--<img :src="funnyList[1].picture" class="image">-->
              <!--</router-link>-->

              <!--<div style="padding: 20px;text-align: center">-->
                <!--<router-link :to="{name:'PaperDetail',query:{tab: 'tab2'}}">-->
                  <!--<el-link style="transition-duration: 0.4s;">-->
                    <!--<div style="font-size: 24px;color: #000000; overflow: hidden;-->
                         <!--white-space: nowrap;text-overflow: ellipsis;">-->
                      <!--{{funnyList[1].title}}-->
                    <!--</div>-->
                  <!--</el-link>-->
                <!--</router-link>-->
              <!--</div>-->

            <!--</el-card>-->
          <!--</el-col>-->

          <!--<el-col :span="6">-->
            <!--<el-card class="funny_card" :body-style="{ padding: '0px' }">-->
              <!--<router-link :to="{name:'PaperDetail',query:{tab: 'tab3'}}">-->
                <!--<img :src="funnyList[2].picture" class="image">-->
              <!--</router-link>-->

              <!--<div style="padding: 20px;text-align: center">-->
                <!--<router-link :to="{name:'PaperDetail',query:{tab: 'tab3'}}">-->
                  <!--<el-link style="transition-duration: 0.4s;">-->
                    <!--<div style="font-size: 24px;color: #000000; overflow: hidden;-->
                         <!--white-space: nowrap;text-overflow: ellipsis;">-->
                      <!--{{funnyList[2].title}}-->
                    <!--</div>-->
                  <!--</el-link>-->
                <!--</router-link>-->
              <!--</div>-->

            <!--</el-card>-->
          <!--</el-col>-->

          <!--<el-col :span="6">-->
            <!--<el-card class="funny_card" :body-style="{ padding: '0px' }">-->
              <!--<router-link :to="{name:'PaperDetail',query:{tab: 'tab4'}}">-->
                <!--<img :src="funnyList[3].picture" class="image">-->
              <!--</router-link>-->

              <!--<div style="padding: 20px;text-align: center">-->
                <!--<router-link :to="{name:'PaperDetail',query:{tab: 'tab4'}}">-->
                  <!--<el-link style="transition-duration: 0.4s;">-->
                    <!--<div style="font-size: 24px;color: #000000; overflow: hidden;-->
                         <!--white-space: nowrap;text-overflow: ellipsis;">-->
                      <!--{{funnyList[3].title}}-->
                    <!--</div>-->
                  <!--</el-link>-->
                <!--</router-link>-->
              <!--</div>-->

            <!--</el-card>-->
          <!--</el-col>-->

      <!--<div class="whats_funny">-->
        <!--<el-row :gutter="80" style="margin-left: 2%;margin-right: 2%">-->

          <!--<el-col :span="8" v-for="item in funnyList" :key="item.title">-->
            <!--<el-card :body-style="{ padding: '0px' }">-->
              <!--<router-link :to="{name:'PaperDetail',query:{paperId:item.paperId}}">-->
                <!--<img :src="item.picture" class="image">-->
              <!--</router-link>-->

              <!--<div style="padding: 20px;text-align: center">-->
                <!--<router-link :to="{name:'PaperDetail',query:{paperId:item.paperId}}">-->
                  <!--<el-link style="transition-duration: 0.4s;">-->
                    <!--<div style="font-size: 24px;color: #000000; overflow: hidden;-->
                         <!--white-space: nowrap;text-overflow: ellipsis;">-->
                      <!--{{item.title}}-->
                    <!--</div>-->
                  <!--</el-link>-->
                <!--</router-link>-->
              <!--</div>-->

            <!--</el-card>-->
          <!--</el-col>-->

        <!--</el-row>-->
      <!--</div>-->

      <!--<div style="margin-top: 7%; margin-bottom: 8%; margin-left: 5%; margin-right: 5%">-->
        <!--<el-divider content-position="center">STAY TUNED...</el-divider>-->
      <!--</div>-->

    <!--</el-footer>-->

  </el-container>
</template>

<script>
import {
  getStatistics,getCommonSearchResult, getAdvancedSearchResult,getMatchAuthor,getMatchAffiliation,getMatchConference
  //   getAffiliationActivityRanking, getAuthorActivityRanking, getResearchDirectionPopularityRanking, getTopPapers, getTopAffiliations, getTopAuthors,  adminLogin,
} from '../../API/Home/HomePageAPIs'
import lo from '../../components/Center'

export default {
  components: {
    lo
  },
  data() {
    return {
      user: {
        login: true,
        logout: false,
        username: 'yry',
        password: '',
        id: '',
        token: ''
      },
      searchAuthor:{},
      searchAffiliation:{},
      searchConference:'',
      searching: false,
      searching_advanced: false,
      dialogVisible: false,
      username: '',
      password: '',
      commonInput: '',
      timedCitedMost: 100,
      articleNumMost_affiliation: 100,
      articleNumMost_author: 100,
      searchCount: 1,
      searchRadio: '1',
      show: true,
      value_year: [2013, 2020],
      options: [
        {
          value: 'author',
          label: 'Author'
        }, {
          value: 'affiliation',
          label: 'Affiliation'
        }, {
          value: 'keyword',
          label: 'Keyword'
        }],
      options1: [
        {
          value: 'ASE',
          label: 'ASE'
        }, {
          value: 'ICSE',
          label: 'ICSE'
        }],
      commonSearchTypeValue: '',
      ase_icse_type: '',
      firstInput: '',
      firstType: '',
      searchContexts: [
        {
          value: '',
          type: '',
          isShow: false,
          isLastOne: false
        }, {
          value: '',
          type: '',
          isShow: false,
          isLastOne: false
        }, {
          value: '',
          type: '',
          isShow: false,
          isLastOne: false
        }, {
          value: '',
          type: '',
          isShow: false,
          isLastOne: false
        }],
      background: {
        backgroundImage: 'url(' + require('@/assets/background.jpg') + ')',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover'
      },
      statisticsNums: {
        authorNum: '',
        affiliationNum: '',
        paperNum: '',
        allArticleCitationCount: ''
      },
      topAffiliationList: [],
      topAuthorList: [],
      topPaperList: [],
      advSearchForm: {
        authors: [],
        affiliations: [],
        startYear: 2000,
        endYear: 2020,
        conferenceName: '',
        keywords: [],
        index: 0
      },
      ranking2s: [
        {
          title: 'Affiliation Activity Ranking',
          contents5: []
        },
        {
          title: 'Author Activity Ranking',
          contents5: []
        },
        {
          title: 'Direction Popularity Ranking',
          contents5: []
        }
      ],
      funnyList: [
        {
          title: 'Scholar Atlas',
          picture: 'https://s1.ax1x.com/2020/04/06/GyRGse.png'
        },
        {
          title: 'Hot Keywords in 2019',
          picture: 'https://s1.ax1x.com/2020/04/06/GyRiGV.png' // 1900*942
        },
        {
          title: 'Minority Fields',
          picture: 'https://s1.ax1x.com/2020/04/06/Gy2vrQ.png'
        },
        {
          title: 'Leaders of Hot Fields',
          picture: 'https://s1.ax1x.com/2020/05/11/YYY8IO.png' // 1900*942
        }
      ]
    }
  },
  methods: {
    login() {
      //   if (this.username === '') {
      //     this.$message({
      //       message: 'Please Enter Username',
      //       center: true
      //     })
      //   } else if (this.password === '') {
      //     this.$message({
      //       message: 'Please Enter Password',
      //       center: true
      //     })
      //   } else {
      //     adminLogin({
      //       username: this.username,
      //       password: this.password
      //     }).then(res => {
      //       if (res.success === '0000') {
      //         localStorage.setItem('Flag', 'isLogin')
      //         this.$message.success({
      //           message: 'Login Successful',
      //           center: true
      //         })
      //         setTimeout(function () {
      //           this.$router.push({
      //             name: 'UploadFile'
      //           })
      //         }.bind(this), 500)
      //       } else {
      //         this.$message.error({
      //           message: res.success ,
      //           center: true
      //         })
      //       }
      //     }).catch(err => {
      //       this.$message.error({
      //         message: err.toString(),
      //         center: true
      //       })
      //     })
      //   }
    },
    toPercent(point) {
      var str = Number(point).toFixed(2)
      return str
    },
    addSearchBox(index) {
      if (this.searchCount <= 4) {
        this.searchCount++
        for (var i = 0; i < this.searchContexts.length; i++) {
          if (!this.searchContexts[i].isShow) {
            this.searchContexts[i].isShow = true
            break
          }
        }
        if (index >= 0) {
          this.searchContexts[index].isLastOne = false
        }
        this.putAddIcon()
      }
    },
    deleteSearchBox(index) {
      this.searchCount--
      this.searchContexts[index].isShow = false
      this.searchContexts[index].value = ''
      this.searchContexts[index].type = ''
      if (this.searchContexts[index].isLastOne) {
        this.searchContexts[index].isLastOne = false
        this.putAddIcon()
      }
    },
    putAddIcon() {
      for (var i = this.searchContexts.length - 1; i >= 0; i--) {
        if (this.searchContexts[i].isShow) {
          this.searchContexts[i].isLastOne = true
          break
        }
      }
    },
    loadData() {
      this.loadStatisticsNums()
      this.loadTopAffiliations()
      this.loadTopAuthors()
      this.loadTopPapers()

      this.loadRankingAffiliation()
      this.loadRankingAuthor()
      this.loadRankingReserchDirection()
    },
    loadStatisticsNums() {
      getStatistics().then(res => {
        console.log(res.content.authorNum)
        if (res.success) {
          this.statisticsNums.authorNum = (res.content.authorNum).toLocaleString('en-US')
          this.statisticsNums.affiliationNum = (res.content.affiliationNum).toLocaleString('en-US')
          this.statisticsNums.paperNum = (res.content.paperNum).toLocaleString('en-US')
          this.statisticsNums.allArticleCitationCount = (res.content.allArticleCitationCount).toLocaleString('en-US')
        } else {
          this.$message.error({
            message: res.success ,
            center: true
          })
        }
      }).catch(error => console.log(error))
    },
    loadTopAffiliations() {
      //   getTopAffiliations().then(res => {
      //     if (res.status.code === '0000') {
      //       this.topAffiliationList = res.data
      //       this.articleNumMost_affiliation = this.topAffiliationList[0].articleNum
      //     } else {
      //       this.$message.error({
      //         message: res.status.msg,
      //         center: true
      //       })
      //     }
      //   }).catch(error => console.log(error))
    },
    loadTopAuthors() {
      //   getTopAuthors().then(res => {
      //     if (res.status.code === '0000') {
      //       this.topAuthorList = res.data
      //       this.articleNumMost_author = this.topAuthorList[0].articleNum
      //     } else {
      //       this.$message.error({
      //         message: res.status.msg,
      //         center: true
      //       })
      //     }
      //   }).catch(error => console.log(error))
    },
    loadTopPapers() {
      //   getTopPapers().then(res => {
      //     if (res.status.code === '0000') {
      //       this.topPaperList = res.data
      //       this.timedCitedMost = this.topPaperList[0].articleCitationCount
      //     } else {
      //       this.$message.error({
      //         message: res.status.msg,
      //         center: true
      //       })
      //     }
      //   }).catch(error => console.log(error))
    },
    loadRankingAffiliation() {
      //   getAffiliationActivityRanking().then(res => {
      //     if (res.status.code === '0000') {
      //       this.ranking2s[0].contents5 = res.data
      //     } else {
      //       this.$message.error({
      //         message: res.status.msg,
      //         center: true
      //       })
      //     }
      //   }).catch(error => console.log(error))
    },
    loadRankingAuthor() {
      //   getAuthorActivityRanking().then(res => {
      //     if (res.status.code === '0000') {
      //       this.ranking2s[1].contents5 = res.data
      //     } else {
      //       this.$message.error({
      //         message: res.status.msg,
      //         center: true
      //       })
      //     }
      //   }).catch(error => console.log(error))
    },
    loadRankingReserchDirection() {
      //   getResearchDirectionPopularityRanking().then(res => {
      //     if (res.status.code === '0000') {
      //       this.ranking2s[2].contents5 = res.data
      //     } else {
      //       this.$message.error({
      //         message: res.status.msg,
      //         center: true
      //       })
      //     }
      //   }).catch(error => console.log(error))
    },
    commonSearch() {
      if (this.searching) {
        return
      }
      if(this.commonSearchTypeValue === ''){
        if (this.commonInput !== '') {
          this.searching = true
          let paperList = []
          let total = 0
          getCommonSearchResult(this.commonInput, 0).then(res => {
            if (res.success) {
              console.log(res.content)
                if(res.content=== "查询结果为0"){
                  paperList=[]
                }else{
                  paperList = res.content.paperBriefInfoVOList
                  total = res.content.totalNum
                }

              console.log(total)
              this.searching = false
              this.$router.push({
                name: 'SearchPaper',
                query: {
                  papers: JSON.stringify(paperList),
                  totalNum: total,
                  content: this.commonInput,
                  kind: '0'
                }
              })
            } else {
              this.searching = false
              this.$message.error({
                message: "Invaild Input",
                center: true
              })
            }
          }).catch(error => console.log(error))
        }else{
          this.$message({
            message: 'Please Enter Something!',
            center: true
          })
        }
      }else if(this.commonSearchTypeValue === 'author'){
        if (this.searchAuthor.name!== '') {
          this.advSearchForm.authors = [this.searchAuthor.name]
          let paperList = []
          let total = 0
          getAdvancedSearchResult(this.advSearchForm).then(res => {
            if (res.success) {
              console.log(res.content)
              if(res.content=== "搜索结果为0"){
                paperList=[]
              }else{
                paperList = res.content.paperBriefInfoVOList
                total = res.content.totalNum
              }
              this.searching = false
              this.$router.push({
                name: 'SearchPaper',
                query: {
                  papers: JSON.stringify(paperList),
                  totalNum: total,
                  content: this.searchAuthor.name+'(Author)',
                  kind: '1'
                }
              })
            } else {
              this.searching = false
              this.$message.error({
                message: "Invaild Input" ,
                center: true
              })
            }
          }).catch(error => console.log(error))
        }else{
          this.$message({
            message: 'Please Enter Something!',
            center: true
          })
        }
      }else if(this.commonSearchTypeValue === 'affiliation'){
        if (this.searchAffiliation.name!== '') {
          this.advSearchForm.affiliations = [this.searchAffiliation.name.replace(/,/ig,'，').replace(/&/ig,'%26').replace(/\+/g, '%2B').
          replace(/\"/g,'%22').
          replace(/\'/g, '%27').
          replace(/\//g,'%2F')]
          let paperList = []
          let total = 0
          getAdvancedSearchResult(this.advSearchForm).then(res => {
            if (res.success) {
              console.log(res.content)
              if(res.content=== "搜索结果为0"){
                paperList=[]
              }else{
                paperList = res.content.paperBriefInfoVOList
                total = res.content.totalNum
              }
              this.searching = false
              this.$router.push({
                name: 'SearchPaper',
                query: {
                  papers: JSON.stringify(paperList),
                  totalNum: total,
                  content: this.searchAffiliation.name+'(Affiliation)',
                  kind: '1'
                }
              })
            } else {
              this.searching = false
              this.$message.error({
                message: "Invaild Input" ,
                center: true
              })
            }
          }).catch(error => console.log(error))
        }else{
          this.$message({
            message: 'Please Enter Something!',
            center: true
          })
        }

      }else {
        if (this.commonInput!== '') {
          this.advSearchForm.keywords = [this.commonInput]
          console.log(this.advSearchForm)
          let paperList = []
          let total = 0
          getAdvancedSearchResult(this.advSearchForm).then(res => {
            if (res.success ) {
              console.log(res.content)
              if(res.content=== "搜索结果为0"){
                paperList=[]
              }else{
                paperList = res.content.paperBriefInfoVOList
                total = res.content.totalNum
              }
              this.searching = false
              this.$router.push({
                name: 'SearchPaper',
                query: {
                  papers: JSON.stringify(paperList),
                  totalNum: total,
                  content: this.commonInput+'(Keyword)',
                  kind: '1'
                }
              })
            } else {
              this.searching = false
              this.$message.error({
                message: "Invaild Input",
                center: true
              })
            }
          }).catch(error => console.log(error))
        }else{
          this.$message({
            message: 'Please Enter Something!',
            center: true
          })
        }
      }
    },
    advancedSearch() {
      // let isnull = true
      this.searching_advanced = true
      let noType = false // 有输入没选类型
      let noValue = false // 选了类型没输入值

      if(this.firstType===''){
        noType=true
      }else{
        if(this.firstType==='author'){
          if(this.searchAuthor.name===''){
            noValue=true
          }
        }
        if(this.firstType==='affiliation'){
          if(this.searchAffiliation.name===''){
            noValue=true
          }
        }
        if(this.firstType==='keyword'){
          if(this.firstInput===''){
            noValue=true
          }
        }
      }
      console.log(noType)
      for (var i = 0; i < this.searchContexts.length; i++) {

        if(this.searchContexts[i].type===''&&this.searchContexts[i].isShow){
          noType=true
        }else{
          if(this.searchContexts[i].type==='author'){
            if(this.searchAuthor.name===''&&!this.searchContexts[i].isShow){
              noValue=true
            }else{

            }
          }
          if(this.searchContexts[i].type==='affiliation'){
            if(this.searchAffiliation.name===''&&!this.searchContexts[i].isShow){
              noValue=true
            }
          }
          if(this.searchContexts[i].type==='keyword'){
            if(this.searchContexts[i].value===''&&!this.searchContexts[i].isShow){
              noValue=true
            }
          }
        }
      }
      if (noType) {
        this.searching_advanced = false
        this.$message({
          message: 'Please Choose Type!',
          center: true
        })
      } else if (noValue) {
        this.searching_advanced = false
        this.$message({
          message: 'Please Enter Something!',
          center: true
        })
      } else {

        this.advSearchForm.startYear = this.value_year[0]
        this.advSearchForm.endYear = this.value_year[1]
        this.advSearchForm.conferenceName = this.ase_icse_type

          if (this.firstType === 'author') {
            this.advSearchForm.authors.push(this.searchAuthor.name)
          } else if (this.firstType === 'affiliation') {
            this.advSearchForm.affiliations.push(this.searchAffiliation.name.replace(/,/ig,'，').replace(/&/ig,'%26').replace(/\+/g, '%2B').
            replace(/\"/g,'%22').
            replace(/\'/g, '%27').
            replace(/\//g,'%2F'))
          } else if (this.firstType === 'keyword') {
            this.advSearchForm.keywords.push(this.firstInput)
          }

        for (var j = 0; j < this.searchContexts.length; j++) {
          if (this.searchContexts[j].value !== '') {
            if (this.searchContexts[j].type === 'author') {
              this.advSearchForm.authors.push(this.searchContexts[j].value)
            } else if (this.searchContexts[j].type === 'affiliation') {
              this.advSearchForm.affiliations.push(this.searchContexts[j].value.replace(/,/ig,'，').replace(/&/ig,'%26').replace(/\+/g, '%2B').
              replace(/\"/g,'%22').
              replace(/\'/g, '%27').
              replace(/\//g,'%2F'))
            } else if (this.searchContexts[j].type === 'keyword') {
              this.advSearchForm.keywords.push(this.searchContexts[j].value)
            }
          }
        }
        let paperList = []
        let total = 0
        getAdvancedSearchResult(this.advSearchForm).then(res => {
          console.log(this.advSearchForm)
          this.advSearchForm.keywords.push(this.searchConference)
          if (res.success ) {
            console.log(res.content)
            if(res.content=== "搜索结果为0"){
              paperList=[]
            }else{
              paperList = res.content.paperBriefInfoVOList
              total = res.content.totalNum
            }
            this.searching_advanced = false
            this.$router.push({
              name: 'SearchPaper',
              query: {
                papers: JSON.stringify(paperList),
                totalNum: total,
                content: this.advSearchForm,
                kind: '1'
              }
            })
          } else {
            this.searching_advanced = false
            this.$message.error({
              message: "Invaild Input" ,
              center: true
            })
          }
        }).catch(error => console.log(error))
      }


    },
    querySearchAsync(queryString, cb) {
      if (queryString && queryString.length > 2) {
        getMatchAuthor(queryString).then(res => {
          console.log(res)
          if (res.success) {
            var list = [{}];
            for(let i of res.content){
              i.value = i.name;  //将想要展示的数据作为value
            }
            list = res.content;
            cb(list);
          }
        })
      }
    },
    handleSelect(item) {
      this.searchAuthor.authorId = item.id
      console.log(this.searchContexts)
    },
    querySearchAsync2(queryString, cb) {
      if (queryString && queryString.length > 2) {
        getMatchAffiliation(queryString).then(res => {
          console.log(res)
          if (res.success) {
            var list = [{}];
            for(let i of res.content){
              i.value = i.name;  //将想要展示的数据作为value
            }
            list = res.content;
            cb(list);
          }
        })
      }
    },
    handleSelect2(item) {
      this.searchAffiliation.affiliationId = item.id

      console.log(this.searchAffiliation.affiliationId, item);
    },
    querySearchAsync3(queryString, cb) {
      if (queryString && queryString.length > 2) {
        getMatchConference(queryString).then(res => {
          console.log(res)
          if (res.success) {
            var list = [];
            for(let i of res.content){
              i.value = i;  //将想要展示的数据作为value
            }
            list = res.content;
            cb(list);
          }
        })
      }
    },
    handleSelect3(item) {
      this.searchConference = item.name

    },
  },
  mounted: function () {
    this.user.username = localStorage.getItem('username')
    this.user.token = localStorage.getItem('token')
    console.log(this.user.token)
    this.loadData()
  }
}
</script>

<style scoped >
  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }

  .bg-purple {
    background-color: rgba(255,255,255,0.43);
  }

  .grid-content {
    min-height: 100px;
  }

  .header_icon{
    margin-top: 25px;
    margin-left: 50px;
  }
  .header_num{
    margin-top: 10px;
    font-size: 34px;
  }
  .header_num:hover{
    font-size: 40px;
    font-weight: bold;
  }
  .header_type{
    margin-top: -5px;
    font-size: 21px;
  }

  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 100%;
  }

  .head_card{
    background-color: #f8f8f8;
    min-height: 80px;
    margin: -20px;
    padding-top: 18px;
  }



  .image {
    width: 100%;
    display: block;
  }
  .common_input:hover{
    box-shadow: 0 0 10px 3px rgba(87, 146, 224, 1);
  }
  .el-divider__text, .el-link{
    font-size: 30px;
  }
  .ranking_1{
    transition-duration: 0.3s;
  }
  .ranking_1:hover{
    box-shadow: 0 2px 12px 10px rgba(0, 0, 0, 0.1);
  }
  .funny_card{
    transition-duration: 0.2s;
  }
  .funny_card:hover{
    box-shadow: 0 2px 12px 10px rgba(0, 0, 0, 0.1);
  }

  .el-select-dropdown__item span{
    opacity: 80%;
  }
</style>


