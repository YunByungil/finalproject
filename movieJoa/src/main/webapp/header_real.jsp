<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* S Header */
	.header{position:relative; z-index:101}
	.header .contents{width:980px; margin:0 auto}
		.header_content{margin-bottom:50px; background-color:#fff; border-bottom:1px solid #eee}
		.header_content .contents{display:flex; justify-content:space-between; padding:30px 6px 25px 5px; background-color:#fff}
		.header_content .contents h1{display:inline-flex; align-items:flex-end; height:53px}
		.header_content .contents h1 a{display:block; float:left; height:100%}
		.header_content .contents h1 a img{display:block; width:auto; height:100%; object-fit:contain}
		.header_content .contents h1 span{font-weight:300; font-size:16px; color:#222; letter-spacing:0.313em; line-height:1.500em}
		.header_content .contents .memberInfo_wrap{display:flex; align-items:center}
		.header_content .contents .memberInfo_wrap li{margin-left:44px; margin-top:2px}
		.header_content .contents .memberInfo_wrap li:first-child{margin-left:0}
		.header_content .contents .memberInfo_wrap li a{display:block; position:relative; padding-bottom:19px}
		.header_content .contents .memberInfo_wrap li a img{width:36px; height:36px}
		.header_content .contents .memberInfo_wrap li a span{position:absolute; bottom:0; left:50%; font-size:13px; color:#666; line-height:1.462em; white-space:nowrap; transform:translate(-50%, 0)}
		.header_content .contents .memberInfo_wrap li.ad_partner{width:136px; height:39px; margin-top:5px}
		.header_content .contents .memberInfo_wrap li.ad_partner + li{margin-left:34px}
		.header_content .contents .memberInfo_wrap li.ad_partner a{width:100%; height:100%; padding-bottom:0}
		.header_content .contents .memberInfo_wrap li.ad_partner a img{width:100%; height:100%}

/* S > GNB
	Description
	- class 'nav' 에 class 'active' 추가시 서브메뉴노출
	- class 'nav' 에 class 'fixed' 추가시 상단고정되며 스타일 변경됨
 */
		.nav{position:absolute; left:0; top:113px; width:100%; padding:5px 0; background-color:#fff}
		.nav:after{content:''; display:block; position:absolute; left:0; top:49px; width:100%; height:2px; background-color:#fb4357}
		.nav:before{content:''; display:block; position:absolute; left:0; bottom:0; width:100%; height:1px; background-color:#a58e8e}
		.nav .contents{position:relative}
		.nav .contents h1{display:none}
			.nav_menu{display:inline-flex}
			.nav_menu > li{width:162px; padding:20px 0}
			.nav_menu > li:first-child{width:137px;}
			.nav_menu > li:first-child .nav_overMenu{padding-left:0}
			.nav_menu > li:first-child .nav_overMenu:before{content:none}
			.nav_menu > li:last-child{width:195px}
			.nav_menu > li:nth-child(2) > h2{left:80px}
			.nav_menu > li:nth-child(3) > h2{left:160px}
			.nav_menu > li:nth-child(4) > h2{left:240px}
			.nav_menu > li:nth-child(5) > h2{left:335px}
			.nav_menu > li:last-child > h2{left:430px}

			.nav_menu > li > h2{position:absolute; top:7px}
			.nav_menu > li > h2 > a{font-weight:500; font-size:16px; color:#222; line-height:1.500em}
			/* .nav_menu > li > h2 > a:hover{text-decoration:underline} */
			.nav_menu > li > h2 > a strong{font-weight:700; color:#fb4357}
				.nav_overMenu{display:none; position:relative; margin-bottom:8px; padding:25px 0 0 25px}
				.nav_overMenu:before{content:''; position:absolute; left:0; top:45px; display:block; width:1px; height:250px; background-color:#eee; opacity:0.8}
				.nav_overMenu h3{height:auto; margin:0; line-height:1em; text-align:left; background-image:none}
				.nav_overMenu a:hover{text-decoration:underline}
				.nav_overMenu dt{padding-top:18px}
				.nav_overMenu dt a{font-weight:700; font-size:14px; color:#222; line-height:1.429em}
				.nav_overMenu dt + dd{margin-top:8px}
				.nav_overMenu dd a{font-weight:400; font-size:14px; color:#666; line-height:2.143em}
				.nav_overMenu dd a.arrowR:after{content:''; display:inline-flex; align-self:center; width:5px; height:9px; margin-left:4px; background:transparent url('./../images/common/ico/arrowR_5x9.png') center/5px 9px scroll no-repeat}

			.totalSearch_wrap{display:inline-flex; position:absolute; right:0; top:7px; padding:0 36px 0 10px}
			.totalSearch_wrap:before{content:''; position:absolute; left:0; top:2px; width:1px; height:20px; background-color:#cacaca}
			.totalSearch_wrap:after{content:''; position:absolute; right:0; top:2px; width:1px; height:20px; background-color:#cacaca}
			.totalSearch_wrap label{display:block}
			.totalSearch_wrap label input[type="text"]{width:180px; height:auto; padding:0 0 0 7px; font-size:16px; color:#222; line-height:1.500em; border:none}
			.totalSearch_wrap .btn_totalSearch{display:block; position:absolute; right:10px; top:-1px; ; width:26px; height:26px; font-size:0; line-height:0; background:transparent url('./../images/common/ico/search.png') center center/26px scroll no-repeat}

			.totalSearch_wrap.active .totalSearchAutocomplete_wrap{display:block}

			

			.totalSearchAutocomplete_wrap{display:none; position:absolute; left:0; top:43px; width:100%; min-width:238px; background-color:#fff; border:1px solid #e1e1e1; border-radius:5px; box-shadow:0 2px 9px 0 rgba(0, 0, 0, 0.1)}
				.totalSearchAutocomplete_list{padding:16px 22px; border-bottom:1px solid #f4f4f4}
				.totalSearchAutocomplete_list dt{font-weight:500; font-size:16px; color:#222; line-height:1.500em}
				.totalSearchAutocomplete_list dt + dd{margin-top:5px}
				.totalSearchAutocomplete_list dd a{font-size:14px; color:#222; line-height:2.214em}
				.totalSearchAutocomplete_list dd a strong{font-weight:400; color:#fb4357}

				.btn_totalSearchAutocomplete_close{float:right; margin:4px 13px 9px; padding-right:15px; font-size:12px; color:#666; line-height:1.417em; background:transparent url('./../images/common/btn/autocompleteClose.png') right center/11px scroll no-repeat}

		.nav.active .nav_overMenu{display:block}

		.nav.fixed{position:fixed; top:0px; min-width:1040px; padding:10px 0}
		.nav.fixed:after{top:0; bottom:auto; height:60px; background-image:linear-gradient(to right, rgb(215, 67, 87), rgb(241,79,58) 59%, rgb(239, 100, 47)); z-index:1}
		.nav.fixed .contents{z-index:2}
		.nav.fixed .contents h1{display:block; position:absolute; left:0; top:1px; width:70px; height:32px; z-index:3}
		.nav.fixed .contents h1 a{display:block} 
		.nav.fixed .contents h1 a img{width:100%; height:100%}
		.nav.fixed .contents .nav_menu > li:first-child > h2{left:120px}
		.nav.fixed .contents .nav_menu > li:nth-child(2) > h2{left:200px}
		.nav.fixed .contents .nav_menu > li:nth-child(3) > h2{left:280px}
		.nav.fixed .contents .nav_menu > li:nth-child(4) > h2{left:360px}
		.nav.fixed .contents .nav_menu > li:nth-child(5) > h2{left:455px}
		.nav.fixed .contents .nav_menu > li:last-child > h2{left:550px}
		.nav.fixed .contents .nav_menu > li > h2 > a{color:#fff}
		.nav.fixed .contents .nav_menu > li > h2 > a strong{color:#fff}
		.nav.fixed .contents .totalSearch_wrap:before,
		.nav.fixed .contents .totalSearch_wrap:after{background-color:#000; opacity:0.2}
		.nav.fixed .contents .totalSearch_wrap label input[type="text"]{color:#fff; background-color:transparent}
		.nav.fixed .contents .totalSearch_wrap .btn_totalSearch{background:transparent url('./../images/common/ico/search_w.png') center center/26px scroll no-repeat}
		.nav.fixed .contents .totalSearchAutocomplete_wrap{position:absolute; left:0; top:49px}
/* E Header */

/* Header AD Area */
#cgvwrap .cgv-ad-wrap {width:100%; height:80px; z-index:101} /* 20140620 position:absolute; top:0; left:0; Del */
#cgvwrap .cgv-ad-wrap .sect-head-ad {width:100%; height:80px; margin:0 auto; text-align:center;}
.sect_txt_banner {height:80px;background:#fefcef}
.sect_txt_banner iframe,.sect_txt_banner .inner {display:block;width:980px;height:80px;margin:0 auto}
iframe#TopBanner {margin: 0 auto;display:block}
.adreduce {position:relative;height:80px;margin:0 auto}
.adextend {position: absolute;left: 50%;top: 0px;z-index: 1000;margin: 0 auto;width: 980px;margin-left: -490px;}


/* 서비스 메뉴 영역 */
.sect-service > .util li > a > span,
.sect-service > .gnb li > a > span {visibility:hidden;}

.sect-service {overflow:hidden; position:relative; height:30px;}
.sect-service > .util {float:left;}
.sect-service > .util > li, .sect-service > .gnb > li, .im-wrap .lnb li {float:left;}
.sect-service > .util li {border-right:1px solid #ddd;}
.sect-service > .util li:first-child {border-left:1px solid #ddd;}
.sect-service > .util li > a {padding:0 10px; line-height:30px;}
.sect-service > .util li > a.app {width:74px; height:30px; background-position:10px -714px;}
.sect-service > .util li > a.like {width:44px; height:30px; background-position:-85px -714px;}
.sect-service > .util li > a.frugal {width:85px; height:30px; background-position:-151px -714px;}
.sect-service > .util li > a.insta {width:60px; height:30px; background-position:-263px -714px;}
.sect-service > .gnb {float:right; margin:0; text-align:left;}
.sect-service > .gnb li {background:url(./../images/common/bg/bg_v_line.gif) no-repeat 0 50%;}
.sect-service > .gnb li:first-child {margin-left:0; background-image:none;}
.sect-service > .gnb li > a {padding:0 10px; line-height:30px;}
.sect-service > .gnb li > a.login {width:29px; background-position:10px 9px;}
.sect-service > .gnb li > a.logout {width:43px; background-position:-521px 9px;}
.sect-service > .gnb li > a.join {width:39px; background-position:-42px 9px;}
.sect-service > .gnb li > a.mycgv {width:39px; background-position:-103px 9px;}
.sect-service > .gnb li > a.vip {width:62px; background-position:-170px 9px;}
.sect-service > .gnb li > a.club {width:53px; background-position:-254px 9px;}
.sect-service > .gnb li > a.customer {width:38px; background-position:-328px 9px;}
.sect-service > .gnb li > a.showtimes {width:106px; padding-right:0; background-position:-388px 9px;}

/* 주메뉴 영역 */
.im-wrap {position:relative; z-index:100; height:50px; padding-top:69px;}
.im-wrap > h2 {position:absolute; top:28px; left:50%; width:428px; height:31px; margin-left:-214px; text-align:center;}
.im-wrap .lnb {width:376px; margin:0 auto; clear:both;} /* 이벤트&컬쳐 : width:376px; 이벤트 / 컬쳐 : width:440px; */
.im-wrap .lnb > ul > li {position:relative; height:35px;}
.im-wrap .lnb > ul > li:first-child {margin-left:0;}
.im-wrap .lnb > ul > li.on .sub-wrap {display:block;}
.im-wrap .lnb > ul > li.booking {margin-left:25px;}
.im-wrap .lnb > ul > li.theaters {margin-left:25px;}
.im-wrap .lnb > ul > li.event {margin-left:40px;}
.im-wrap .lnb > ul > li.culture {margin-left:40px;}
.im-wrap .lnb > ul > li.giftshop {margin-left:55px;}
.im-wrap .lnb > ul > li.movie > a, 
.im-wrap .lnb > ul > li.event > a, 
.im-wrap .lnb > ul > li.theaters > a, 
.im-wrap .lnb > ul > li.giftshop > a, 
.im-wrap .lnb > ul > li.booking > a,
.im-wrap .lnb > ul > li.culture > a {height:17px; text-align:center;}
.im-wrap .lnb > ul > li.movie > a {width:60px; background-position:13px -28px;}
.im-wrap .lnb > ul > li.booking > a {width:60px; background-position:-77px -28px;}
.im-wrap .lnb > ul > li.theaters > a {width:60px; background-position:-166px -28px;}
.im-wrap .lnb > ul > li.event > a {width:47px; background-position:-272px -28px;}
.im-wrap .lnb > ul > li.culture > a {width:90px; background-position:-517px -28px;}
.im-wrap .lnb > ul > li.giftshop > a {width:62px; background-position:-379px -28px;}

.im-wrap .lnb .sub-wrap {display:none; position:absolute; top:31px; z-index:100; width:164px; padding:3px; background:url(https://img.cgv.co.kr/r2014/images/common/bg/bg_smenu.png) repeat-y 0 0;}
.im-wrap .lnb > ul > li.movie > .sub-wrap {left:-56px;}
.im-wrap .lnb > ul > li.booking > .sub-wrap {left:-56px;}
.im-wrap .lnb > ul > li.theaters > .sub-wrap {left:-56px;}
.im-wrap .lnb > ul > li.event > .sub-wrap {left:-40px;}
.im-wrap .lnb > ul > li.culture > .sub-wrap {left:-37px;}

.im-wrap .lnb .sub-wrap > .smenu {padding:20px 15px; border:2px solid #828282;}
.im-wrap .lnb .sub-wrap > i {display:block; position:absolute; top:-10px; left:50%; width:19px; height:10px; margin-left:-9px; background:url(https://img.cgv.co.kr/r2014/images/common/ico/ico_smenu_arrow.png) no-repeat 0 0;}
.im-wrap .lnb .sub-wrap > .smenu li {margin-top:15px;}
.im-wrap .lnb .sub-wrap > .smenu li:first-child {margin-top:0;}
.im-wrap .lnb .sub-wrap > .smenu li > a {display:block; width:130px; color:#fff; font-weight:500; font-size:13px; line-height:15px;}
.im-wrap .lnb .sub-wrap > .smenu li > a:hover, 
.im-wrap .lnb .sub-wrap > .smenu li > a:focus, 
.im-wrap .lnb .sub-wrap > .smenu li.on > a {background:url(https://img.cgv.co.kr/r2014/images/common/ico/ico_smenu_hand.png) no-repeat 100% 1px; color:#fb4357;}
.im-wrap .lnb .sub-wrap > .smenu li.last {padding-top:15px; border-top:2px solid #828282;}

/* 통합검색 영역 */
.sect-srh {top:65px; left:749px; width:141px; height:24px;}
.sect-srh input[type='text'] {width:100px; height:22px; padding:0 34px 0 5px;}
.sect-srh > fieldset {position:relative;}
.sect-srh > fieldset button {position:absolute; top:0; right:0; width:31px; height:24px; background-color:#fb4357; background-image:none; color:#fff; font-weight:500; font-size:11px; line-height:24px; text-align:center;}
*+html .sect-srh > fieldset button {top:8px;}

/* 헤더 광고 영역 */
.im-wrap .ad-partner {position:absolute; top: 16px;left: 754px;}
.im-wrap .ad-partner > iframe,
.im-wrap .ad-partner > a,
.im-wrap .ad-partner > a > img {width: 133px;height: 42px;display: block;background:#FEF8DC;}

/* 예매 영역 */
.sect-booking {top:10px; right:0px;}
.sect-booking > a {width:86px; height:99px; background-position:0 -319px;}
/* 퀵메뉴 포토티켓 영역 */
.sect-phototicket {top:-10px; right:-1px;}
.sect-phototicket > a {width:91px; height:86px; background-position:-364px -305px;}
/* 개인화 영역 */
.sect-person {width:980px; height:80px; margin:8px auto 9px; padding:9px 0 15px; background:url(https://img.cgv.co.kr/r2014/images/common/bg/bg_com_line.png) repeat-x 0 100%; clear:both}
.sect-person > ul > li {float:left; position:relative; border-left:1px solid #231d1d}
.sect-person > ul > li:first-child {border-left:0;}
.sect-person > ul > li > a {width:161px; height:80px;}
.sect-person > ul > li > a.week {background-position:15px -89px;}
.sect-person > ul > li > a.theater {background-position:-128px -88px;}
.sect-person > ul > li > a.event {background-position:-270px -89px;}
.sect-person > ul > li > a.special {background-position:-413px -90px;}
.sect-person > ul > li > a.movielog {background-position:24px -196px;}
.sect-person > ul > li > a.ticket {background-position:-142px -197px;}
.sect-person > ul > li > a.dc {background-position:-324px -196px;}
.sect-person > ul > li > a.collage {background-position:-510px -196px;}
.sect-person > ul > li > a.arthouse {background-position:-510px -197px;background-image:url(http://img.cgv.co.kr/R2014/images/sprite/common_sprite_area_v2.png)}
.sect-person > ul > li > a.phototicket {background-position:-587px -88px;background-image:url(http://img.cgv.co.kr/R2014/images/sprite/common_sprite_area_v3.png)}
</style>
</head>
<body>
<div class="nav">
    <div class="contents">
        <h1><a href="/" tabindex="-1"><img src="https://img.cgv.co.kr/R2014/images/common/logo/logoWhite.png" alt="CGV" /></a></h1>
        <ul class="nav_menu">
            <li>
                <h2><a href="/movies/?lt=1&ft=0">영화</a></h2>
                <dl class="nav_overMenu">
                    <dt><h2><a href="/movies/?lt=1&ft=0" tabindex="-1">영화</a></h2></dt>
                    <dd><h3><a href="/movies/?lt=1&ft=0">무비차트</a></h3></dd>
                    <dd><h3><a href="/arthouse/">아트하우스</a></h3></dd>
                    <dd><h3><a href="/culture-event/event/detailViewUnited.aspx?seq=30717">ICECON</a></h3></dd>
                </dl>
            </li>
            <li>
                <h2><a href="/theaters/">극장</a></h2>
                <dl class="nav_overMenu">
                    <dt><h2><a href="/theaters/" tabindex="-1">극장</a></h2></dt>
                    <dd><h3><a href="/theaters/">CGV 극장</a></h3></dd>
                    <dd><h3><a href="/theaters/special/defaultNew.aspx">특별관</a></h3></dd>
                </dl>
            </li>
            <li>
                <h2><a href="/ticket/"><strong>예매</strong></a></h2>
                <dl class="nav_overMenu">
                    <dt><h2><a href="/ticket/" tabindex="-1">예매</a></h2></dt>
                    <dd><h3><a href="/ticket/">빠른예매</a></h3></dd>
                    <dd><h3><a href="/reserve/show-times/">상영스케줄</a></h3></dd>
                    <dd><h3><a href="/ticket/eng/newdefault.aspx">English Ticketing</a></h3></dd>
                    <dd><h3><a href="/reserve/show-times/eng/">English Schedule</a></h3></dd>
                </dl>
            </li>
            <li>
                <h2><a href="/culture-event/popcorn-store/">스토어</a></h2>
                <dl class="nav_overMenu">
                    <dt><h2><a href="/culture-event/popcorn-store/" tabindex="-1">스토어</a></h2></dt>
                    
                            <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=2">영화관람권</a></h3></dd>
                        
                            <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=3">기프트카드</a></h3></dd>
                        
                            <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=4">콤보</a></h3></dd>
                        
                            <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=5">팝콘</a></h3></dd>
                        
                            <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=6">음료</a></h3></dd>
                        
                            <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=7">스낵</a></h3></dd>
                        
                            <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=10">플레이존</a></h3></dd>
                        
                    <dd><h3><a href="https://brand.naver.com/cgv" class="arrowR" target="_blank">씨네샵</a></h3></dd>
                </dl>
            </li>
            <li>
                <h2 onclick=""><a href="/joaEventMain.do">이벤트</a></h2>
                <dl class="nav_overMenu">
                    <dd><h3><a href="#">당첨자 발표</a></h3></dd>
                    <dd><h3><a href="/joaEventEnded.do">종료된 이벤트</a></h3></dd>
                </dl>
            </li>
            <li>
                <h2 onclick="gaEventLog('PC_GNB','주메뉴_해택','')"><a href="/discount/discountlist.aspx">혜택</a></h2>
                <dl class="nav_overMenu">
                    <dt><h2><a href="/discount/discountlist.aspx" tabindex="-1">혜택</a></h2></dt>
                    <dd><h3><a href="/discount/discountlist.aspx">CGV 할인정보</a></h3></dd>
                    <dd><h3><a href="https://www.cgv.co.kr/user/memberShip/ClubService.aspx">CLUB 서비스</a></h3></dd>
                    <dd><h3><a href="/user/vip-lounge/">VIP 라운지</a></h3></dd>
                </dl>
            </li>
        </ul>
        <div class="totalSearch_wrap">
            <label for="totalSearch">
                <input type="text" id="header_keyword" value="" />
                <input type="hidden" id="header_ad_keyword" name="header_ad_keyword" />
            </label>
            <button type="button" class="btn_totalSearch" id="btn_header_search">검색</button>
            <iframe src="//ad.cgv.co.kr/NetInsight/html/CGV/CGV_201401/main@Search_txt" width="0" height="0" title="" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" allowfullscreen="allowfullscreen" mozallowfullscreen="mozallowfullscreen" msallowfullscreen="msallowfullscreen" oallowfullscreen="oallowfullscreen" webkitallowfullscreen="webkitallowfullscreen"></iframe>
            <!--<div class="totalSearchAutocomplete_wrap">
                <dl class="totalSearchAutocomplete_list">
                    <dt>영화</dt>
                    <dd><a href="#none"><strong>전지</strong>적 작가시점</a></dd>
                    <dd><a href="#none">내언니 <strong>전지</strong>현과 나</a></dd>
                    <dd><a href="#none">수호<strong>전지</strong> 영웅본색</a></dd>
                </dl>
                <dl class="totalSearchAutocomplete_list">
                    <dt>인물</dt>
                    <dd><a href="#none"><strong>전지</strong>현</a></dd>
                    <dd><a href="#none"><strong>전지</strong>희</a></dd>
                    <dd><a href="#none">이<strong>전지</strong></a></dd>
                </dl>
                <a href="#none" class="btn_totalSearchAutocomplete_close">닫기</a>
            </div>//-->
        </div>
    </div>
</div>
</body>
</html>