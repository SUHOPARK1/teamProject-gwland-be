package com.tplus.gwland.cmm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class reviewer {@Override public String toString() {
				return "<"+pceNum+">"+revStar+", "+revNick+ ", " 
					  	             +revContent+", "+revDate;}
	String revStar; String revNick; String revContent; String revDate; String pceNum;
	
	public reviewer(
			 String revStar, String revNick, 
			 String revContent, String revDate, String pceNum){
		super();
		this.revStar = revStar;
		this.revNick = revNick;
		this.revContent = revContent;
		this.revDate = revDate;
		this.pceNum = pceNum;}
	
	public String getRevStar() {return revStar;}
	public void setRevStar(String revStar) {this.revStar = revStar;}
	public String getRevNick() {return revNick;}
	public void setRevNick(String revNick) {this.revNick = revNick;}
	public String getRevContent() {return revContent;}
	public void setRevContent(String revContent) {this.revContent = revContent;}
	public String getRevDate() {return revDate;}
	public void setRevDate(String revDate) {this.revDate = revDate;}}

public class Crawler {
	public static List<reviewer> placeAutoUrl(ChromeDriver driver, String url, String number){
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement rev = driver.findElementByClassName("list_evaluation");
		
		List<WebElement> ls = rev.findElements(By.cssSelector("li"));
		List<reviewer> revList = new ArrayList<>();
		for(int i=0;i<ls.size();i++) {
			String revNick = ls.get(i).findElement(By.className("link_user")).getText();
			String revContent = ls.get(i).findElement(By.className("txt_comment")).getText();
			String revStar = ls.get(i).findElement(By.className("num_rate")).getText();
			String revDate = ls.get(i).findElement(By.className("time_write")).getText();
			revList.add(new reviewer(revStar,revNick,revContent,revDate,number));
			System.out.println(revList.get(i).toString());}
		return revList;}
	
	/*(예외처리) 6, 가도 가도 또 가고 싶은 여행지의 스테디셀러
	   	       7, 가슴 탁 트이는 속초여행 
	   	       24. 대포항에서 혼자 하는 여행
	   	       47. 설악 관광특구
	   	       62. 설악산국립공원의 비경을 만나다
	   	       65. 설악파인리조트 아쿠아펀
	   	       75. 속초 음악불꽃크루즈 2021
	   	       76. 속초 응골딸기나라 (관광두레 주민사업체)
	   	       81. 속초관광수산시장 닭강정골목
	   	       89. 속초연안 배낚시
	   	       90. 속초의 석호에서 만나는 특별한 체험
	   	       93. 속초해안로
	   	       126. 장사어촌계 배낚시
	   	       130. 저마다 가을 색을 뽐내는 속초로 떠나는 여행 [웰촌]
	   	       135. 지친 몸과 마음을 치유하는 시간
	   	       140. 척산온천지구
	   	       148. 청초호 둘레길 */
	   	       
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
			
 	    placeAutoUrl(driver,"https://place.map.kakao.com/21449945","1");      //뉴욕제과
		placeAutoUrl(driver,"https://place.map.kakao.com/19125965","2");      //함흥냉면옥
		placeAutoUrl(driver,"https://place.map.kakao.com/10924317","3");      //함흥막국수
		placeAutoUrl(driver,"https://place.map.kakao.com/25622898","4");      //88생선구이
		placeAutoUrl(driver,"https://place.map.kakao.com/1903622145","5");    //YAT(와이에이티)
																    	      //예외처리(6,7)
		placeAutoUrl(driver,"https://place.map.kakao.com/10116103","8");      //갈릴리횟집
		placeAutoUrl(driver,"https://place.map.kakao.com/8141879","9");       //감나무집 감자옹심이
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/11041736","10");     //계조암
		placeAutoUrl(driver,"https://place.map.kakao.com/8201549","11");      //광림모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/25625906","12");     //국립산악박물관
		placeAutoUrl(driver,"https://place.map.kakao.com/8216097","13");      //굿모닝가족호텔
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/1364813679","14");   //궁중해장국본가
		placeAutoUrl(driver,"https://place.map.kakao.com/8206191","15");      //금강굴
		placeAutoUrl(driver,"https://place.map.kakao.com/11891822","16");     //낙천회관
		placeAutoUrl(driver,"https://place.map.kakao.com/8250511","17");      //노블모텔
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/20089686","18");     //뉴스타트설악리조트
		placeAutoUrl(driver,"https://place.map.kakao.com/1618971940","19");   //다이나믹 메이즈
		placeAutoUrl(driver,"https://place.map.kakao.com/9703855","20");      //단천식당
		placeAutoUrl(driver,"https://place.map.kakao.com/9697792","21");      //대궐파크
		placeAutoUrl(driver,"https://place.map.kakao.com/21814112","22");     //대포마을
		placeAutoUrl(driver,"https://place.map.kakao.com/10324177","23");     //대포항
																		      //예외처리(24)
		placeAutoUrl(driver,"https://place.map.kakao.com/315908155","25");    //더 레드 하우스
		placeAutoUrl(driver,"https://place.map.kakao.com/27010613","26");     //동명방파제
		placeAutoUrl(driver,"https://place.map.kakao.com/12656758","27");     //동명마을
		placeAutoUrl(driver,"https://place.map.kakao.com/1123919078","28");   //전복해물뚝배기
		placeAutoUrl(driver,"https://place.map.kakao.com/7843350","29");      //동명항
		placeAutoUrl(driver,"https://place.map.kakao.com/11892233","30");     //동해순대국
		placeAutoUrl(driver,"https://place.map.kakao.com/10364864","31");     //두메산골
		placeAutoUrl(driver,"https://place.map.kakao.com/7851701","32");      //등대해변
		placeAutoUrl(driver,"https://place.map.kakao.com/27392264","33");     //롯데리조트 속초
		placeAutoUrl(driver,"https://place.map.kakao.com/8998463","34");      //모아모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/11248590","35");     //미라지모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/20706973","36");     //발해역사관
		placeAutoUrl(driver,"https://place.map.kakao.com/26035534","37");     //백두해물짬뽕순두부
		placeAutoUrl(driver,"https://place.map.kakao.com/14749593","38");     //베니키아 호텔 산과바다 대포항
		placeAutoUrl(driver,"https://place.map.kakao.com/11305083","39");     //보광사
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/1364813679","40");   //본가 궁중해장국
		placeAutoUrl(driver,"https://place.map.kakao.com/10455856","41");     //블루오션설악밸리
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/7902860","42");      //비룡폭포
		placeAutoUrl(driver,"https://place.map.kakao.com/7904044","43");      //비선대
		placeAutoUrl(driver,"https://place.map.kakao.com/8340024","44");      //사돈집
		placeAutoUrl(driver,"https://place.map.kakao.com/853690564","45");    //상도문돌담마을
		placeAutoUrl(driver,"https://place.map.kakao.com/7951458","46");      //석봉도자기미술관
																		      //예외처리(47)
		placeAutoUrl(driver,"https://place.map.kakao.com/23256180","48");     //설악 대청봉
		placeAutoUrl(driver,"https://place.map.kakao.com/7949134","49");      //설악 케이블카
		placeAutoUrl(driver,"https://place.map.kakao.com/12664858","50");     //설악 파인리조트 가든스파
		placeAutoUrl(driver,"https://place.map.kakao.com/11134307","51");     //설악 흔들바위
		placeAutoUrl(driver,"https://place.map.kakao.com/8693759","52");      //설악금호리조트
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/21054684","53");     //설악동야영장
		placeAutoUrl(driver,"https://place.map.kakao.com/17721245","54");     //설악레저스쿨
		placeAutoUrl(driver,"https://place.map.kakao.com/8216362","55");      //설악산 권금성
		placeAutoUrl(driver,"https://place.map.kakao.com/8036325","56");	  //설악산 울산바위
		placeAutoUrl(driver,"https://place.map.kakao.com/24414762","57");	  //설악산 자생식물원
		placeAutoUrl(driver,"https://place.map.kakao.com/8375070","58");      //설악산 탐방안내소
		placeAutoUrl(driver,"https://place.map.kakao.com/7944159","59");	  //설악산가족호텔
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/21054684","60");     //설악산국립공원 자동차야영장
		placeAutoUrl(driver,"https://place.map.kakao.com/15147983","61");     //설악산국립공원(외설악)
																			  //예외처리(62)
		placeAutoUrl(driver,"https://place.map.kakao.com/26290244","63");     //설악산소공원
		placeAutoUrl(driver,"https://place.map.kakao.com/9168616","64");      //설악산파크리조트
																			  //예외처리(65)
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/10494265","66");     //설악파인리조트
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/7939479","67");      //설악프라자컨트리클럽
		placeAutoUrl(driver,"https://place.map.kakao.com/1327493089","68");   //설악힐호텔
		placeAutoUrl(driver,"https://place.map.kakao.com/7952590","69");      //속초 등대전망대
		placeAutoUrl(driver,"https://place.map.kakao.com/649182629","70");    //속초 바다낚시   		
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/8376588","71");      //설악해맞이공원
		placeAutoUrl(driver,"https://place.map.kakao.com/27351432","72");     //얼라이브 하트(Alive Heart)
		placeAutoUrl(driver,"https://place.map.kakao.com/12697671","73");     //엑스포타워
		placeAutoUrl(driver,"https://place.map.kakao.com/1970947390","74");   //외옹치 바다향기로
																		      //예외처리(75)
																			  //예외처리(76)
		placeAutoUrl(driver,"https://place.map.kakao.com/8065637","77");      //속초 조양동 유적
		placeAutoUrl(driver,"https://place.map.kakao.com/19304774","78");     //속초 하도문쌈채 마을,
		placeAutoUrl(driver,"https://place.map.kakao.com/1970947390","79");   //외옹치 바다향기로
		placeAutoUrl(driver,"https://place.map.kakao.com/12797187","80");     //속초관광수산시장
																		      //예외처리(81)
		placeAutoUrl(driver,"https://place.map.kakao.com/7952759","82");      //속초문화원
		placeAutoUrl(driver,"https://place.map.kakao.com/10543534","83");     //속초문화회관			
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/374570243","84");    //속초비치호스텔
		placeAutoUrl(driver,"https://place.map.kakao.com/24751102","85");     //속초스파랜드
		placeAutoUrl(driver,"https://place.map.kakao.com/9158247","86");      //속초시립박물관
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/371169740","88");    //속초엑스포유람선
																			  //예외처리(89)
																		      //예외처리(90)
		placeAutoUrl(driver,"https://place.map.kakao.com/7958898","91");      //속초항
		placeAutoUrl(driver,"https://place.map.kakao.com/22099937","92");     //속초해변
																		      //예외처리(93)
		placeAutoUrl(driver,"https://place.map.kakao.com/1311816688","94");   //속초휘테
		placeAutoUrl(driver,"https://place.map.kakao.com/19947943","95");     //솔밭가든막국수
		placeAutoUrl(driver,"https://place.map.kakao.com/11126744","96");     //송월파크
		placeAutoUrl(driver,"https://place.map.kakao.com/797562421","97");    //스머프하우스
		placeAutoUrl(driver,"https://place.map.kakao.com/10543253","98");     //시골이모순두부
		placeAutoUrl(driver,"https://place.map.kakao.com/10532834","99");     //시골할머니		
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/11435044","100");    //시나브로 모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/1098447501","101");  //신다신식당     
		placeAutoUrl(driver,"https://place.map.kakao.com/1098447501","102");  //신다신식당
		placeAutoUrl(driver,"https://place.map.kakao.com/7993485","103"); 	  //아남프라자
		placeAutoUrl(driver,"https://place.map.kakao.com/11495403","104");    //아바이마을 갯배
		placeAutoUrl(driver,"https://place.map.kakao.com/11951680","105");    //아바이마을
		placeAutoUrl(driver,"https://place.map.kakao.com/19624242","106");    //아이리스9
		placeAutoUrl(driver,"https://place.map.kakao.com/978709031","107");   //양반댁함흥냉면
		placeAutoUrl(driver,"https://place.map.kakao.com/7994126","108");     //에이스모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/24857116","109");    //연호리조트
		placeAutoUrl(driver,"https://place.map.kakao.com/7999903","110");     //영금정           	  
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/8011765","111");     //영랑호 화랑도 체험관광단지
		placeAutoUrl(driver,"https://place.map.kakao.com/8008145","112");     //영랑호
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/10650417","113");    //영랑호리조트
		placeAutoUrl(driver,"https://place.map.kakao.com/24451703","114");    //옛고을순두부
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/10633799","115");    //오대양횟집
		placeAutoUrl(driver,"https://place.map.kakao.com/9267011","116");     //옥돌할머니순두부
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/9293198","117");     //왕건횟집
		placeAutoUrl(driver,"https://place.map.kakao.com/632257610","118");   //외옹치마을
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/8021355","119");     //외옹치항
		placeAutoUrl(driver,"https://place.map.kakao.com/8016468","120");     //외옹치해변
		placeAutoUrl(driver,"https://place.map.kakao.com/9366982","121");     //위너스모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/1131080213","122");  //위드유			
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/10688023","123");    //육담폭포
		placeAutoUrl(driver,"https://place.map.kakao.com/24267521","124");    //일출봉횟집
		placeAutoUrl(driver,"https://place.map.kakao.com/13606733","125");    //장사마을
																			  //에외처리(126)
		placeAutoUrl(driver,"https://place.map.kakao.com/10737561","127");    //장사항
		placeAutoUrl(driver,"https://place.map.kakao.com/11441632","128");    //장원파크텔
		placeAutoUrl(driver,"https://place.map.kakao.com/21345651","129");    //재래식할머니순두부
																		      //예외처리(130)
		placeAutoUrl(driver,"https://place.map.kakao.com/11170136","131");    //전주속풀이해장국
		placeAutoUrl(driver,"https://place.map.kakao.com/13320662","132");	  //점봉산산채
		placeAutoUrl(driver,"https://place.map.kakao.com/9395122","133");     //조광모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/18682831","134");    //족욕공원
																			  //에외처리(135)
		placeAutoUrl(driver,"https://place.map.kakao.com/8086528","136");  	  //진미횟집
		placeAutoUrl(driver,"https://place.map.kakao.com/10763109","137");    //진솔할머니순두부
		placeAutoUrl(driver,"https://place.map.kakao.com/8086427","138");     //진양횟집
		placeAutoUrl(driver,"https://place.map.kakao.com/8092408","139");     //척산온천장
																			  //예외처리(140)
		placeAutoUrl(driver,"https://place.map.kakao.com/12924037","141");    //척산온천휴양촌
		placeAutoUrl(driver,"https://place.map.kakao.com/18682831","142");    //척산족욕공원		
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/10762824","143");    //천당폭포
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/8091417","144");     //천불동계곡
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/8088618","145");     //청대산
		placeAutoUrl(driver,"https://place.map.kakao.com/16106479","146");    //청초비치 모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/26602585","147");    //청초수물회
																			  //예외처리(148)
		placeAutoUrl(driver,"https://place.map.kakao.com/8105816","149");	  //청초호
		placeAutoUrl(driver,"https://place.map.kakao.com/11247110","150");    //청호해변
		placeAutoUrl(driver,"https://place.map.kakao.com/27158330","151");    //청호활어회센터
		placeAutoUrl(driver,"https://place.map.kakao.com/10842950","152");    //초당할머니집
		placeAutoUrl(driver,"https://place.map.kakao.com/125251387","153");   //초원리조텔
		placeAutoUrl(driver,"https://place.map.kakao.com/9511628","154");     //최옥란할머니순두부
		placeAutoUrl(driver,"https://place.map.kakao.com/11755111","155");    //카페뮤토
		placeAutoUrl(driver,"https://place.map.kakao.com/10493578","156");    //켄싱턴호텔 설악
		placeAutoUrl(driver,"https://place.map.kakao.com/8102174","157");     //코리아횟집
		placeAutoUrl(driver,"https://place.map.kakao.com/10901906","158");    //텔콘채록지			
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/25035970","159");    //토왕성폭포
		placeAutoUrl(driver,"https://place.map.kakao.com/11620926","160");    //평강막국수
		placeAutoUrl(driver,"https://place.map.kakao.com/8133251","161");     //학무정
		placeAutoUrl(driver,"https://place.map.kakao.com/12706186","162");    //학사평 콩꽃마을 순두부촌
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/21510540","163");    //한송정가든
		placeAutoUrl(driver,"https://place.map.kakao.com/10482115","164");    //한화리조트 설악 워터피아
		placeAutoUrl(driver,"https://place.map.kakao.com/27025531","165");    //한화리조트 설악
		placeAutoUrl(driver,"https://place.map.kakao.com/8149034","166");     //해림모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/10923704","167");    //해맞이모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/26564223","168");    //해파랑길 45코스
		placeAutoUrl(driver,"https://place.map.kakao.com/27491575","169");    //해피하우스
		placeAutoUrl(driver,"https://place.map.kakao.com/9641200","170");     //헬리오스모텔
		placeAutoUrl(driver,"https://place.map.kakao.com/17101514","171");    //현대수리조트
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/761418386","172");   //호텔 느낌
		placeAutoUrl(driver,"https://place.map.kakao.com/12868448","173");    //호텔 마레몬스
		placeAutoUrl(driver,"https://place.map.kakao.com/25815063","174");    //호텔 아마란스 
//양식x	placeAutoUrl(driver,"https://place.map.kakao.com/8011765","175");     //화랑도체험관광단지
		placeAutoUrl(driver,"https://place.map.kakao.com/345442586","176");   //화이트스테이션 호스텔
		placeAutoUrl(driver,"https://place.map.kakao.com/11203702","177");}}   //황두막
		