0.스프링프레임워크
1.스프링프로젝트들
 1.스프링 MVC :
   웹애플리케이션 개발을 위한 프레임워크
     아키텍처에서는 MVC 패턴을 채택
       MVC: 요청에 따라 실행할 처리 행위(Action)을 결정하고, 처리 결과로 HTML(view)과 같은 응답을 반환하는 프레임워크
  since: Sprf 3.0 부터 크게 개선됨

 2.스프링시큐리티 :
   보안 기능을 쉽게 구현할 수 있도록 도와주는 프레임워크
     보안기능: 인증(Authentication) + 인가(Authorization)
       인증: 베이직 인증, 다이제스트 인증(digest authentication), X.509, LDAP, Open ID
       인가:
     기타: CSRF 대응 기능, 보안 응답 헤더 출력 기능, 세션관리

 3.스프링 데이터 :
   데이터 저장소에 있는 데이터에 접근할 수 있게 해주는 프레임워크
     데이터저장소: 관계형 DB, NoSQL, Key-Value 저장소
   내부 프로젝트
     -Spring DataCommon : 데이터 접근에 필요한 공통 인터페이스
     -Spring Data JPA : JPA(Java Persistence API)를 이용해 데이터에 접근하기 위한 모듈
     -Spring Data MonggoDB, Spring Data Redis, Spring Data Solr 등
     -기타

 4.스프링 배치
   배치(batch) 애플리테이션을 개발하기 위한 경량 프레임워크
     배치(batch):
 5.스프링 인티그레이션
   EIP(Enterprise Integration Patterns)로 알려진 시스템 연계 아키텍처 패턴에 기초해서 연계 애플리케이션을 쉽게 개발할 수 있게 도와주는 프레임워크

 6.스프링 클라우드
 7.스프링 툴 스위트
 8.스프링 IO 플랫폼
   스프링 기반 애플리케이션을 개발하고 실행할 때 필요한 스프링 관련 라이브러리나 서드파티 라이러리의 버전을 결정하고, 의존관계를 해결하기 위한 스프링 프로젝트
   (= 각종 라이브러리 버전과 의존 관계를 설정)
     내부적으로 스프링부트와 그레일즈(Grails)를 실행 환경(DSR: Domain Specific Runtime)으로 지원하고 있음

9.스프링 부트
  최소한의 설정으로로 프로덕션 레벨의 스프링 기반 애플리케이션을 쉽게 개발 할 수 있도록 도와주는 스프링 프로젝트
   XML이나 자바 기반 설정을 이용한 서블릿(Servlet) 설정 등을 하지 않아도 되고, 별도의 애플리케이션 서버에 디플로이할 필요도 없다.


(부졔: Endpoint 에서 일어나는 많은 일들 꼬꼬무)
2.데이터 바인딩(Data Binding)
  자바 객체의 프로퍼티에 외부에서 입력된 값을 설정하는 과정
  (= 외부에서 입력한 값을 자바 객체의 프로퍼티에 설정하는 과정
   = 요청 데이터를 자바 객체의 프로퍼티에 설정하는 과정)
    외부: **웹 애플리케이션이 요청 파라미터, 프로퍼티 파일의 설정 값, XML 기반 설정에서 빈을 정의할 때 지정한 프로퍼티 값
  **자바빈(JavaBean): 자바로 작성된 소프트웨어 (재사용이 가능한)컴포넌트
                     자바빈즈 스펙을 따르는 컴포넌트
                      - 직렬화 (저장 및 복원)
                      - 기본생성자
                      - set,get(기본 이름 규칙을 따라야 함)
   https://imasoftwareengineer.tistory.com/101
  **스프링 빈(Bean) : DI 컨테이너가 관리하는 애플리케이션을 구성하는 컴포넌트 역할의 자바 객체
           자바빈즈 : 데이터 바인딩이나 프로퍼티 관점에서 다뤄지는 객체
   https://velog.io/@kdhyo/BeanUtils.copyProperties를-사용해보자


3.데이터 접근(JDBC, Tx)


5.웹 애플리케이션 개발
 1.웹애플리개이션 종류
  화면으로 응답하는 애플리케이션
   JSP와 같은 템플릿 파일을 사용해 동적 웹페이지(HTML)형태로 클라이언트에 응답한다,
  데이터로 응답하는 애플리케이션(RESTful 애플리케이션)
   JSON 또는 XML을 사용해 데이터 형태로 클라이언트에 응답한다.
    클라이언트: SPA, Rich Client
 2.애플리케이션 설정
  서블릿 컨테이너 설정(ContextLoaderListener, DispatchServlet, CharacterEncodingFilter)
   서블릿 3.0.0 이후의 서블릿 컨테이너에서는 자바로 서블릿 컨테이너의 초기화를 할 수 있다.
  애플리케이션 컨텍스트 설정(MessageSource, PropertySourcesPlaceholderConfigurer@2.4절)
   MessageSource: 메시지를 취득하기 위함 컴포넌트
   PropertySourcesPlaceholderConfigurer: 프로퍼티 값(JVM 시스템 프로퍼티, 환경 변수, 프로퍼티 파일에 정의한 값)을
    DI 컨테이너에서 관리하는 컴포넌트에 인젝션하기 위한 컴포넌트
  프런트 컨트롤러 설정 @4.2,3절
   자바 기반설정: @EnableMvc
   XML 기반설정: <mvc:annotation-driven>
 3.@Controller 구현
   *@웹 애플리케이션 주요 컴포넌트: 컨트롤러 클래스, 폼 클래스, 뷰(템플릿 파일: jsp...)
  1.구현할 처리 내용(처리할 내용)
   선언형 처리: 메서드 시그니처를 참조해서 프런트 컨트롤러가 하는 일
   프르그래밍형 처리: 컨트롤러 클래스의 메서드 안에 하는 일
    #선언형          |  프로그래밍형
     --------------------
     요청매핑        | 입력값 검사 결과 확인
     요청데이터 취득   | 비즈니스 로직 호출
     입력값 검사 수행  | 이동 대상 확인 및 데이터 연계
                   | 이동 대상 지정
  2.컨트롤러 클래스 작성
   @Controller(value="") 지정
    컴포넌트 스캔 대상, 컨테이너에 빈으로 등록할 수 있다
    요청을 처리하는 메서드(핸들러 메서드)가 정의돼 있는 클래스로 인식된다.
   DI 컨테이너 등록(컴포넌트 스캔기능 이용)
    자바 기반: @ComponentSan("example.app")
    XML 기반: <context:component-scan base-package="example.app" />

  3.핸들러 메서드 작성
   요청을 처리하는 메서드 작성
    @RequestMapping을 지정한 메서드가 핸들러 메서드(HandlerMethod)로 인식된다.
     핸들러 메서드로 인식되면 프런트 컨트롤러가 지정한 정보를 읽고 요청에 대응하는 핸들러 메서드를 자동으로 호출한다.
  4.핸들러 메서드의 매개변수   https://velog.io/@gillog/Spring-HandlerMethodArgumentResolver-PathVariable-RequestHeader-RequestParam
    인수로 여러 객체를 받을 수 있다.
     *@ 메서드의 매개변수로 받을 수 있는 객체는 (HandlerMethodArgumentResolver 인터페이스의 구현 클래스를 만드는 방법으로 확장할 수 있다.
      (RequestMappingHandlerMapping and RequestMappingHandlerAdapter)
   지정 가능한 주요 타입
    Model, RedirectAttributes, JavaBeans, BindingResult, MultipartFile, HttpEntity<?>, Locale, ZoneId, Principal, UriComponentsBuilder, SessionStatus
     타입을 선택할 때 주의할 점
       서블릿 API 나 저수준 자바 API 의 타입을 사용하면 유지보수를 힘들게 할 수도 있다.(최소화 하자)
   지정 가능한 주요 애너테이션

  5.핸들러 메서드의 반환값
   *@ HandlerMethodReturnValueHandler 인터페이스의 구현 클래스를 만드는 방법으로 확장할 수 있다.
   지정 가능한 주요 타입
    String, Model, ModelAndView, void, ResponseEntity<?>, HttpHeaders
    String 이동 대상의 뷰 이름 반환
    Model 이동 대상에 전달할 데이터를 반환
    ModelAndView 이동 대상의 뷰 이름과 이동 대상에 전달할 데이터를 반환
    void HttpResponse 에 직접 응답 데이터를 쓰거나 RequestToViewNameTranslator 의 메커니즘을 이용해 뷰 이름을 결정할 때 void 를 사용한다.
    ResponseEntity<?> 응답 헤더와 응답 본문에 직렬화될 객체를 반환한다. 반환한 객체는 HttpMessageConverter 메커니즘을 이용해 임의의 형식으로 직렬화 된다.
    HttpHeaders 응답 헤더만 반환한다.
   지정 가능한 주요 에너테이션 - 임의의 객체를 Model 에 저장하거나 응답 본문에 직렬화할 수 있다.
    @ModelAttribute Model 에 저장하는 객체를 반환한다.(자바빈즈인 경우 생략 가능)
    @ResponseBody 응답 본문에 직렬화하는 객체를 반환한다. 객체는 HttpMessageConverter 의 메커니즘을 이용해 임의의 형식으로 직렬화된다.
  6.뷰 컨트롤러 이용

 4.요청 매핑(Request Mapping)
  *@  클래스 레벨/ 메서드 레벨 모두에 지정 가능 (Can be specified for both class level/method level)
  스프링 MVC 는 @RequestMapping 의 속성값을 사용해 요청 매핑 조건을 지정한다. (각각의 서로 다른 속성은 AND 조건 취급)
  @RequestMapping 속성
   value - 요청 경로(패턴) 지정
   path - value 속성의 별명 지정
   method - http 메서드 값(GET, POST, PUT)을 지정
   params - 요청 파라미터 유무나 파라미터 값을 지정
   headers - 헤더 유무나 헤더 값을 지정
   consumes - Content-Type 헤더값(미디어 타입)을 지정한다.
   produces - Accept 헤더 값(미디어 타입)을 지정한다.
   name - 매핑 정보에 임의의 이름을 지정한다. 이 속성에 지정하는 값에 따라 룰이 바뀌는 것음 없다.
  요청 경로 사용
   필수정보로서 클래스나 매서드에 매핑한다.
    요청 경로 혹은 경로 패턴을 지정할 때는 value 속성이나, path 속성에 기재햐면 된다.
     속성값 여러 개 지정 가능(OR 조건 취급)
   클래스레벨 - 기본경로로 취급
   메서드레벨 - 기본경로 + 상대경로 형태로 취급
  경로 패턴 사용
   동적으로 표현된 경로 패턴도 지정할 수 있다
    URI 템플릿 형식의 경로 패턴 (/account/{accountId})
    URI 템플릿 형식의 경로 패턴 + 정규 표현식 (/accounts/{accountId:[a-f0-9-]{36}})
    앤트 스타일의 경로 패턴( /**/accounts/email )
  HTTP 메서드 사용
   method 속성을 사용한다
    GET 메서드: 웹 페이지의 내용을 보거나, 파일을 다운로드 하는 것과 같이 어떤 정보를 취득할 때 사용한다.
    POST 메서드: 서버에 정보 전송할 때 사용한다
   여러 개 지정 가능
  요청 파라미터 사용
   요청 파라 미터를 매핑 조건에 사용하는 경우 params 속성을 사용한다.
    속성값 여러 개 지정 가능(AND 조건 취급)
     *#params 속성 지원 형식
      name   | 지정한 파라미터가 존재하는 경우 매핑 대상이 됨
      !name  | 지정한 파라미터가 존재하지 않는 경우 매핑 대상이 됨
      name=value | 파라미터 값이 지정한 값에 해당하는 경우에 매핑 대상이 됨
      name!=value | 파라미터 값이 지정한 값에 해당하지 않는 경우 매핑 대상이 됨
  요청 헤더 사용
   요청 헤더를 매핑 조건으로 지정하는 경우 headers 속성을 사용한다.
    속성 지원 형식은 params 와 같다
  Content-Type 헤더 사용
   Content-Type 헤더 값을 매핑 조건으로 지정하는 경우 consumes 속성을 사용한다.
    요청 본문의 미디어 타입을 정한다.
     mediaType, !mediaType (consumes="application/json")
  Accept 헤더 사용
   Accept 헤더 값을 매핑 조건으로 지정하는 경우 produces 속성을 사용한다.
    응답 본문의 미디어 타입을 정한다
     mediaType, !mediaType (produces="application/json")
  요청 데이터 취득
   경로 변수값 취득 @PathVariable (value="") 타입 변수이름 - 경로 변수의 값은 Model 객체에 같은 이름으로 저장된다.
   요청 파라미터 값 취득 @RequestParam
   요청 헤더 값 취득 @RequestHeader
   쿠키 값 취득 @CookieValue
   요청 파라미터 값 일괄 취득 자바빈즈(자바빈즈 프로퍼티에 바인딩 해서 취득한다)
   *# 지억 가능한 속성(@RequestParam, @RequestHeader, @CookieValue)
   value 값을 취득하는 파라미터명을 지정
   name value 속성의 별명
   required 파라미터 필수 여부 지정(default true) 하고 파라미터가 존재하지 않는 경우 BindingException, 400(Bad Request)로 취급함
   defaultValue 기본값 지정, 지정한 경우 required 속성은 강제로 false 가 된다


**************************************
cheat sheet - spring  mainly using types in Parameter of Handler Method (with Controller)
**************************************
Model 이동 대상에 전달할 데이터를 가지고 있는 인터페이스
RedirectAttributes 리다이렉트 대상에 전달할 데이터를 가지고 있는 인터페이스
JavaBeans 요청 파라미터를 가지고 있는 자바빈즈 클래스
BindingResult 폼 클래스의 입력값 검사 결과를 가지고 있는 인터페이스
MultipartFile 멀티파트 요청을 사용해 업로드된 파일 정보를 가지고 있는 인터페이스
HttpEntity 요청 헤더와, 응답 본문을 가지고 있는 인터페이스, 요청 본문은 HttpMessageConverter 의 메커니즘을 사용해 임의의 타입으로 변활할 수 있다.
Locale client Locale
ZoneId client 시간대(8이상)
Principal 클라이언트 인증을 위한 사용자 정보를 가지고 있는 인터페이스
UrlComponentsBuilder URI 를 조립하기 위한 인터페이스, 컨텍스트 경로를 기준 uRI로 가지고 있는 객체가 전달된다.
SessionStatus @SessionAttributes 를 사용해 세션 스코프에 저장한 객체의 라이프 사이클을 관리하는 인터페이스(세션 값 설정과 설정 완료 여부만 확인)

**************************************
cheat sheet - spring  mainly using annotation in Parameter of Handler Method (with Controller)
(= 인수 에너테이션) 인수에 애너테이션을 지정하면 요청 데이터(경로 변수, 요청 파라미터, 요청 본문, 쿠키)를 임의의 타입으로 변환해서 자져올 수 있다.
**************************************
인수에서 지정 가능한 애너테이션
@PathVariable - URL 에서 경로 변수 값을 가져오기 위한 애너테이션
@MatrixVariable - URL 에서 매트릭스 변수 값을 가져오기 위한 에너테이션(기본 설정에서는 사용할 수 없다)
@RequestParam - 요청 파라미터 값을 가져오기 위한
@RequestHeader - 요청 헤더 값 가져오기
@RequestBody - 요청 본문 내용을 가져오기 위한 에너테이션 -> 요청 본문은 HttpMessageConverter 구조를 사용해 지정한 타입으로 변환된다.
@CookieValue - 쿠키 값을 가져오기 위한

요청 데이터 이외의 정보를 인수로 지정할 수 있는 에너테이션
@ModelAttribute - 모델에 지정된 객체를 인수로 받을 수 있다. 인수가 자바빈즈 형태라면 생략할 수 있다.
@Value - '${...}'와 같은 플레이스홀더로 대체된 값이나 '#{...}'과 같은 SpEL 식의 실행 결과를 인수로 받을 수 있다

since SPRF v4.3~
@SessionAttribute - HttpSession 에 저장된 객체를 가져오기 위한 애너테이션
@RequestAttribute - HttpServlet 에 저장된 객체를 가져오기 위한 애너테이션
