
package com.it7890.orange.manage.controller.contentController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.model.SysUser;
import com.it7890.orange.manage.service.articalService.*;
import com.it7890.orange.manage.service.articalService.IConArticleService;
import com.it7890.orange.manage.service.articalService.IHbCountrysService;
import com.it7890.orange.manage.utils.MD5;
import com.it7890.orange.manage.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Description: 文章管理Controller
 * @date 2015年11月12日 下午2:42:49
 */
@Controller
@RequestMapping("/article")
public class ConArticleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private IConArticleService conArticleService;

    @Resource
    private ITopicsService topicsService;
    @Resource
    ISysUserService sysuserService;
    @Resource
    private IConChannelService conchannelService;
    @Resource
    private IHbLanguageService hblanguageService;
    @Resource
    private IConPublicationService conpublicationService;
    @Resource
    private IHbCountrysService hbcountryService;

/*
    @Value("#{configProperties['appkey']}")
    private String appkey;
    @Value("#{configProperties['appMasterSecret']}")
    private String appMasterSecret;

    @Value("#{configProperties['iosappkey']}")
    private String iosappkey;
    @Value("#{configProperties['iosappMasterSecret']}")
    private String iosappMasterSecret;

    @Value("#{configProperties['appkey2']}")
    private String appkey2;
    @Value("#{configProperties['appMasterSecret2']}")
    private String appMasterSecret2;*/

    /**
     * 文章列表
     *
     * @param request
     * @param model
     * @param topicid       话题
     * @param id
     * @param langid        国际化语言
     * @param starttime     开始时间
     * @param endtime       结束时间
     * @param keywords      关键字
     * @param countrycode
     * @param status        状态 0:正常  1:未审核  2:预发布
     * @param publicationid 发布人
     * @param channelid     渠道
     * @param page
     * @return 文章列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String articlelist(HttpServletRequest request, Model model,
                              @RequestParam(value = "topicid", required = false) Integer topicid,
                              @RequestParam(value = "id", required = false) String id,
                              @RequestParam(value = "langid", required = false) String langid,
                              @RequestParam(value = "starttime", required = false) String starttime,
                              @RequestParam(value = "endtime", required = false) String endtime,
                              @RequestParam(value = "keywords", required = false) String keywords,
                              @RequestParam(value = "countrycode", required = false) String countrycode,
                              @RequestParam(value = "status", required = false) Integer status,
                              @RequestParam(value = "attr", required = false) Integer attr,
                              @RequestParam(value = "publicationid", required = false) Integer publicationid,
                              @RequestParam(value = "channelid", required = false) Integer channelid,
                              @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        HttpSession session = request.getSession();
        session.setAttribute("page", page);
        ConArticle article = new ConArticle();
        StringBuffer searchstr = new StringBuffer();
        if (id != null && !"".equals(id.trim())) {
            id = id.trim();
            article.setId(Long.valueOf(id));
            searchstr.append("&id=" + id);
        }
        if (topicid != null && !"".equals(topicid)) {
            article.setTopicsid(topicid);
            searchstr.append("&topicid=" + topicid);
        }
        if (starttime != null && !"".equals(starttime)) {
            article.setStarttime(starttime);
            searchstr.append("&starttime=" + starttime);
        }
        if (endtime != null && !"".equals(endtime)) {
            article.setEndtime(endtime);
            searchstr.append("&endtime=" + endtime);
        }
        if (keywords != null && !"".equals(keywords)) {
            keywords = keywords.trim();
            article.setKeywords(keywords);
            searchstr.append("&keywords=" + keywords);
        }
        if (countrycode != null && !"".equals(countrycode)) {
            countrycode = countrycode.trim().toLowerCase();//es搜索时不识别大写
            article.setCountrycode(countrycode);
            searchstr.append("&countrycode=" + countrycode);
        }
        if (attr != null && !"".equals(attr) && !attr.equals("-1")) {
            article.setAttr(attr);
            searchstr.append("&attr=" + attr);
        } else {
            article.setAttr(-1);
        }
        if (status != null && !"".equals(status)) {
            article.setStatus(status);
            searchstr.append("&status=" + status);
        }
        if (publicationid != null && !"".equals(publicationid) && publicationid > 0) {
            article.setPublicationid(publicationid);
            searchstr.append("&publicationid=" + publicationid);
        }
        if (channelid != null && !"".equals(channelid) && channelid > 0) {
            article.setChannelid(channelid);
            searchstr.append("&channelid=" + channelid);
        }
        if (langid != null && !langid.equals("") && Integer.parseInt(langid) > 0) {
            article.setLangid(langid);
            searchstr.append("&langid=" + langid);
        }
        //总记录数
        int total = (int) conArticleService.articletotal(article);
        //分页
        PageUtil pageUtil = new PageUtil();
        if (page > 1000) page = 1000;
        if (page > 1) {
            pageUtil.setRecordCount(total);
            pageUtil.setCurrentPage(page);
        }
        if (page == 1) {
            pageUtil.setRecordCount(total);
            pageUtil.setCurrentPage(1);
        } else {
            pageUtil.setRecordCount(total);
            pageUtil.setCurrentPage(page);
        }
        List<ConArticle> list = conArticleService.getarticlelist(article, pageUtil);
        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("article", article);
        model.addAttribute("searchstr", searchstr);
        model.addAttribute("articles", list);
        model.addAttribute("hbtopics", topicsService.getAllHbTopics());
        model.addAttribute("conchannels", conchannelService.getAllConChannel());
        model.addAttribute("publications", conpublicationService.getAllConpublication());
        model.addAttribute("users", sysuserService.getAllSysUser());
        model.addAttribute("languagesSort", hblanguageService.getAllHbLanguageOrderByHbcode());
//        model.addAttribute("channellist", ruleService.getChannellist());
        return "article/list";
    }

    /**
     * 转到添加或修改页面
     *
     * @param rquest
     * @param response
     * @param model
     * @param id
     * @return 转到添加或修改页面
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String articleadd(HttpServletRequest rquest,
                             HttpServletResponse response, Model model, int id) {
        ConArticle article;
        if (id == 0) {
            article = new ConArticle();
            article.setId(id);
            article.setStatus(-1);
            article.setSubtime(new Date());
        } else {
            article = conArticleService.getConArticleByIdES(id);
        }
        //	model.addAttribute("upyunhttp", upyunutil.getUpyunhttp());
        model.addAttribute("article", article);
        model.addAttribute("hbcountrys", hbcountryService.getHbCountrysAll());
        model.addAttribute("hbtopics", topicsService.getAllHbTopics());
        model.addAttribute("conchannels", conchannelService.getAllConChannelByStatus());
        model.addAttribute("hblanguages", hblanguageService.getAllHbLanguage());
        model.addAttribute("conpublications", conpublicationService.getAllConpublication());
        return "article/add";
    }

    /**
     * 添加或修改文章
     *
     * @param request
     * @param response
     * @param conarticle 文章对象
     * @param model
     * @return
     */
    @RequestMapping(value = "/saveorupdate", method = RequestMethod.POST)
    public String articlesaveorupdate(HttpServletRequest request,
                                      HttpServletResponse response, ConArticle conarticle, Model model) {
        //搜索记忆
        StringBuffer str = new StringBuffer();
        str.append("page=" + request.getSession().getAttribute("page"));
        if (request.getSession().getAttribute("topicid") != null && !"".equals(request.getSession().getAttribute("topicid"))) {
            int topicid = (int) request.getSession().getAttribute("topicid");
            str.append("&topicid=" + topicid);
        } else {
            str.append("&topicid=");
        }
        if (request.getSession().getAttribute("starttime") != null && !"".equals(request.getSession().getAttribute("starttime"))) {
            String starttime = (String) request.getSession().getAttribute("starttime");
            str.append("&starttime=" + starttime);
        } else {
            str.append("&starttime=");
        }
        if (request.getSession().getAttribute("endtime") != null && !"".equals(request.getSession().getAttribute("endtime"))) {
            String endtime = (String) request.getSession().getAttribute("endtime");
            str.append("&endtime=" + endtime);
        } else {
            str.append("&endtime=");
        }
        if (request.getSession().getAttribute("keywords") != null && !"".equals(request.getSession().getAttribute("keywords"))) {
            String keywords = (String) request.getSession().getAttribute("keywords");
            str.append("&keywords=" + keywords);
        } else {
            str.append("&keywords=");
        }
        if (request.getSession().getAttribute("countrycode") != null && !"".equals(request.getSession().getAttribute("countrycode"))) {
            String countrycode = (String) request.getSession().getAttribute("countrycode");
            str.append("&countrycode=" + countrycode);
        } else {
            str.append("&countrycode=");
        }
        if (conarticle.getStatus() >= 0) {
            int status = (int) conarticle.getStatus();
            str.append("&status=" + status);
        } else {
            str.append("&status=");
        }
        if (request.getSession().getAttribute("author") != null && !"".equals(request.getSession().getAttribute("author"))) {
            String author = (String) request.getSession().getAttribute("author");
            str.append("&author=" + author);
        } else {
            str.append("&author=");
        }
        if (request.getSession().getAttribute("publicationid") != null && !"".equals(request.getSession().getAttribute("publicationid"))) {
            String publicationid = (String) request.getSession().getAttribute("publicationid");
            str.append("&publicationid=" + publicationid);
        } else {
            str.append("&publicationid=");
        }
        if (request.getSession().getAttribute("channelid") != null && !"".equals(request.getSession().getAttribute("channelid"))) {
            String channelid = (String) request.getSession().getAttribute("channelid");
            str.append("&channelid=" + channelid);
        } else {
            str.append("&channelid=");
        }
        int result = 0;
        SysUser sysuer = (SysUser) request.getSession().getAttribute("sysuser");
        conarticle.setCreateuid(sysuer.getUserid());
        conarticle.setSubuid(sysuer.getUserid());
        if (conarticle.getId() == 0) {
            conarticle.setArticleid(MD5.MD524(conarticle.getTitle() + UUID.randomUUID().toString()));
            conarticle.setWriter(sysuer.getTruename());
            conarticle.setChannelid(3);
            //conarticle.setPublicationid(4094);
            conarticle.setStatus(1);
        } else {
            ConArticle ca = conArticleService.getConArticleByIdES((int) conarticle.getId());
            ca.setAbstracts(conarticle.getAbstracts());
            ca.setTitle(conarticle.getTitle());
            ca.setAttr(conarticle.getAttr());
            ca.setCtype(conarticle.getCtype());
            ca.setAbstracts(conarticle.getAbstracts());
            ca.setKeywords(conarticle.getKeywords());
            ca.setAuthor(conarticle.getAuthor());
            ca.setSource(conarticle.getSource());
            ca.setSourceurl(conarticle.getSourceurl());
            ca.setLinkurl(conarticle.getLinkurl());
            ca.setMedialink(conarticle.getMedialink());
            ca.setSubtime(conarticle.getSubtime());
            ca.setStatus(conarticle.getStatus());
            ca.setTitlepic(conarticle.getTitlepic());
            ca.setLangid(conarticle.getLangid());
            ca.setCountrycode(conarticle.getCountrycode());
            ca.setTopicsid(conarticle.getTopicsid());
            ca.setPublicationid(conarticle.getPublicationid());
            ca.getAbstracts();
            AVObject conArticle = new AVObject("ConArticle");

            try {
                conArticle.save();
            } catch (AVException e) {
                e.printStackTrace();
            }
        }

        result = 1;
        request.getSession().setAttribute("message",
            "添加或修改文章:" + (result > 0 ? "成功" : "失败"));
        return String.format("redirect:/message");
    }


    /**
     * 删除文章
     *
     * @param request
     * @param response
     * @param objectId
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletearticle(HttpServletRequest request,
                                HttpServletResponse response, int objectId, Model model) {

        //搜索记忆
        StringBuffer str = new StringBuffer();
        str.append("page=" + request.getSession().getAttribute("page"));
        if (request.getSession().getAttribute("topicid") != null && !"".equals(request.getSession().getAttribute("topicid"))) {
            int topicid = (int) request.getSession().getAttribute("topicid");
            str.append("&topicid=" + topicid);
        } else {
            str.append("&topicid=");
        }
        if (request.getSession().getAttribute("starttime") != null && !"".equals(request.getSession().getAttribute("starttime"))) {
            String starttime = (String) request.getSession().getAttribute("starttime");
            str.append("&starttime=" + starttime);
        } else {
            str.append("&starttime=");
        }
        if (request.getSession().getAttribute("endtime") != null && !"".equals(request.getSession().getAttribute("endtime"))) {
            String endtime = (String) request.getSession().getAttribute("endtime");
            str.append("&endtime=" + endtime);
        } else {
            str.append("&endtime=");
        }
        if (request.getSession().getAttribute("keywords") != null && !"".equals(request.getSession().getAttribute("keywords"))) {
            String keywords = (String) request.getSession().getAttribute("keywords");
            str.append("&keywords=" + keywords);
        } else {
            str.append("&keywords=");
        }
        if (request.getSession().getAttribute("countrycode") != null && !"".equals(request.getSession().getAttribute("countrycode"))) {
            String countrycode = (String) request.getSession().getAttribute("countrycode");
            str.append("&countrycode=" + countrycode);
        } else {
            str.append("&countrycode=");
        }
        if (request.getSession().getAttribute("status") != null && !"".equals(request.getSession().getAttribute("status"))) {
            int status = (int) request.getSession().getAttribute("status");
            str.append("&status=" + status);
        } else {
            str.append("&status=");
        }
        if (request.getSession().getAttribute("author") != null && !"".equals(request.getSession().getAttribute("author"))) {
            String author = (String) request.getSession().getAttribute("author");
            str.append("&author=" + author);
        } else {
            str.append("&author=");
        }
        if (request.getSession().getAttribute("publicationid") != null && !"".equals(request.getSession().getAttribute("publicationid"))) {
            String publicationid = (String) request.getSession().getAttribute("publicationid");
            str.append("&publicationid=" + publicationid);
        } else {
            str.append("&publicationid=");
        }
        if (request.getSession().getAttribute("channelid") != null && !"".equals(request.getSession().getAttribute("channelid"))) {
            String channelid = (String) request.getSession().getAttribute("channelid");
            str.append("&channelid=" + channelid);
        } else {
            str.append("&channelid=");
        }

        int result = 1;
        // 执行 CQL 语句实现更新一个 Todo 对象
        try {
            AVQuery.doCloudQuery("delete from Todo where objectId=?", objectId);

        } catch (Exception e) {
            result = 0;
            e.printStackTrace();
        }

        request.getSession().setAttribute("message",
            "删除文章:" + (result > 0 ? "成功" : "失败"));
        request.getSession().setAttribute("url", "article/list?" + str);
        return String.format("redirect:/message");
    }


}
