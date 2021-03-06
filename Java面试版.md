# 汇总

1. 由Spring AOP引申出来的动态代理知识。（AOP的思想，Spring Aop如何设计与实现，aop事务的隔离级别和传播特性，aop切面的功能 和继承的关系 ，jdk动态代理和cglib动态代理什么区别，SpringAOP用的哪一种代理（都有用到） ）

    AOP是一种“面向切面编程”。可以通过预编译方式和运行期动态代理实现在不修改源代码的情况下给程序动态统一添加功能的一种技术。AOP主要用于日志记录，性能统计，安全控制，事务处理（说到事务处理就会提到aop事务的隔离级别和传播特性），异常处理等等wn及扩展。
     
    Spring Aop设计与实现是基于动态代理的方式：
    
    动态代理步骤：
    1. 创建一个实现接口InvocationHandler的类，它必须实现invoke方法
    2. 创建被代理的类以及接口
    3. 通过Proxy的静态方法newProxyInstance(ClassLoaderloader, Class[] interfaces, InvocationHandler h)创建一个代理
    4. 通过代理调用方法
               
            调用处理器实现类（有木有感觉这里就是传说中的AOP啊）
            /** 
             * 调用处理器实现类 
             * 每次生成动态代理类对象时都需要指定一个实现了该接口的调用处理器对象 
             */  
            public class InvocationHandlerImpl implements InvocationHandler  
            {        
                    /** 
                     * 这个就是我们要代理的真实对象 
                     */  
                    private Object subject;  
                  
                    /** 
                     * 构造方法，给我们要代理的真实对象赋初值 
                     * 
                     * @param subject 
                     */  
                    public InvocationHandlerImpl(Object subject)  
                    {  
                        this.subject = subject;  
                    }  
                  
                    /** 
                     * 该方法负责集中处理动态代理类上的所有方法调用。 
                     * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行 
                     * 
                     * @param proxy  代理类实例 
                     * @param method 被调用的方法对象 
                     * @param args   调用参数 
                     * @return 
                     * @throws Throwable 
                     */  
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable  
                    {  
                        //在代理真实对象前我们可以添加一些自己的操作  
                        System.out.println("在调用之前，我要干点啥呢？");  
                  
                        System.out.println("Method:" + method);  
                  
                        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用  
                        Object returnValue = method.invoke(subject, args);  
                  
                        //在代理真实对象后我们也可以添加一些自己的操作  
                        System.out.println("在调用之后，我要干点啥呢？");                   
                        return returnValue;  
                    }  
                }   
             -------------------------------------------------------------------------   
            Subject realSubject = new RealSubject();
            /** 
             * InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发 
             * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用. 
             * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法 
             */  
            InvocationHandler handler = new InvocationHandlerImpl(realSubject);  
      
            ClassLoader loader = realSubject.getClass().getClassLoader();  
            Class[] interfaces = realSubject.getClass().getInterfaces();  
            /** 
             * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例 
             */  
            Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);  
      
            System.out.println("动态代理对象的类型："+subject.getClass().getName());  
      
            String hello = subject.SayHello("jiankunking");  
            System.out.println(hello);  
    
     **代理执行逻辑**
     1. 需求->在原有方法A基础上拼接新的方法BC
     2. 实现
          1. 静态代理
                1. 写一个新类y，实现原有方法A的类x继承的接口
                2. 将ABC三个方法包装进y的一个新方法中
                3. 调用处执行类y的方法
            
          2. 动态代理
                1. 将创建新类y的过程抽象出了来，改成通用的过程
                    1. 要接口->JDK动态代理
                    2. 不要接口->CGLib动态代理
                2. 将ABC三个方法包装进y的一个新方法中 
                3. 调用处执行类y的方法   
    ---
   **下面是由AOP谈到事务处理作用衍生出来的数据库问题**
    ---
    Aop的事务隔离级别有5个:（这里其实就和数据库的隔离级别一个样）
    
        1. ISOLATION_DEFAULT： 这是一个PlatfromTransactionManager默认的隔离级别，使用数据库默认的事务隔离级别。
        2. ISOLATION_READ_UNCOMMITTED： 这是事务最低的隔离级别，它允许令外一个事务可以看到这个事务未提交的数据。
        3. ISOLATION_READ_COMMITTED： 保证一个事务修改的数据提交后才能被另外一个事务读取。另外一个事务不能读取该事务未提交的数据。
        4. ISOLATION_REPEATABLE_READ： 这种事务隔离级别可以防止脏读，不可重复读。但是可能出现幻像读。它除了保证一个事务不能读取另一个事务未提交的数据外，还保证了避免下面的情况产生(不可重复读)。
        5. ISOLATION_SERIALIZABLE 这是花费最高代价但是最可靠的事务隔离级别。事务被处理为顺序执行。 除了防止脏读，不可重复读外，还避免了幻像读
        
     spring特有的--> ISOLATION_DEFAULT，另外四个与JDBC的隔离级别相对应(未提交读,提交读,可重复读,序列化)。第二种隔离级别会产生脏读，不可重复读和幻像读，特别是脏读，一般情况下是不允许的，所以这种隔离级别是很少用到的。大多说数据库的默认是第三种。它能消除脏读，但是可重复读保证不了。第四种隔离级别也有一些数据库作为默认的隔离级别，比如MySQL。最后一种用的地方不多，除非是多数据访问的要求特别高，否则轻易不要用它，因为它会严重影响数据库的性能。
    
    传播方式:
    
    如果两个在代码上不相关的操作，需要放在同一个事务中，这就需要利用到传播特性了。这时调用的传播特性的值就应该是PROPAGATION_REQUIRED。在spring中只需要进行这样的配置，就实现了声明式的事物处理。
    
          1. PROPAGATION_REQUIRED: 如果存在一个事务，则支持当前事务。如果没有事务则开启新的事物。
          2. PROPAGATION_SUPPORTS: 如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行。
          3. PROPAGATION_MANDATORY: 如果已经存在一个事务，支持当前事务。如果没有一个活动的事务，则抛出异常。
          4. PROPAGATION_REQUIRES_NEW: 总是开启一个新的事务。如果一个事务已经存在，则将这个存在的事务挂起。
          5. PROPAGATION_NOT_SUPPORTED: 总是非事务地执行，并挂起任何存在的事务。
          6. PROPAGATION_NEVER: 总是非事务地执行，如果存在一个活动事务，则抛出异常
          7.(spring)PROPAGATION_NESTED：如果一个活动的事务存在，则运行在一个嵌套的事务中. 如果没有活动事务, 则按TransactionDefinition.PROPAGATION_REQUIRED 属性执行。
    
    ---
2. Spring MVC 请求处理流程(工作流)等等，实现解耦的过程，优缺点等和Spring的关系。
 
    **和Spring的关系**
    
    Spring可以说是一个管理bean的容器，也可以说是包括很多开源项目的总称，spring mvc是其中一个开源项目
    基于Spring实现的MVC框架。不能不使用Spring，单独使用SpringMVC，因为其需要依赖Ioc容器等。
    但是如果单独为了更好的理解SpringMVC这种MVC框架，就把它和Struts/Struts2等一系列的MVC框架，
    只是基于DispatcherServlet或者Filter做一个前端分发器，最终把这个框架引导起来，进行其自己的逻辑处理。
    **请求处理流程（原理）**
    
    （简述）简单走个流程的话，http请求一到，由容器（如：tomact）解析http搞成一个request，
    通过映射关系（路径，方法，参数啊）被spring mvc一个分发器去找到可以处理这个请求
    的bean，那tomcat里面就由spring管理bean的一个池子（bean容器）里面找到，
    处理完了就把响应返回回去。经常看到写个springmvc的controller里面有个
    注解service吧，看起来不像类属性吧？spring的ioc功能就可以把这个sercice插进去（反射）
    
        （详细）
        1、客户端发出一个http请求给web服务器，web服务器对http请求进行解析，如果匹配DispatcherServlet的请求映射路径（在web.xml中指定），web容器将请求转交给DispatcherServlet.
        2、DipatcherServlet接收到这个请求之后将根据请求的信息（包括URL、Http方法、请求报文头和请求参数Cookie等）以及HandlerMapping的配置找到处理请求的处理器（Handler）。        
        3-4、DispatcherServlet根据HandlerMapping找到对应的Handler,将处理权交给Handler（Handler将具体的处理进行封装），再由具体的HandlerAdapter对Handler进行具体的调用。
        5、Handler对数据处理完成以后将返回一个ModelAndView()对象给DispatcherServlet。
        6、Handler返回的ModelAndView()只是一个逻辑视图并不是一个正式的视图，DispatcherSevlet通过ViewResolver将逻辑视图转化为真正的视图View。
        7、Dispatcher通过model解析出ModelAndView()中的参数进行解析最终展现出完整的view并返回给客户端。
        
     简而言之，SpringMVC通过DispatcherServlet这个前端控制器(也叫中央调度器，我认为中央调度器更能体现其作用)，
     来调用mvc的三大件:Controller、Model、View。这样就保证MVC的每一个组件只与DispatcherServlet耦合，而彼此之间独立运行，
     大大降低了程序的耦合性。  再来说一下，SpringMVC这个框架时如何实现MVC模式的。  注意SpringMVC中并没有涉及有关于Controller接口规范的实现,
     SpringMVC是通过调用Handler来实现Controller这一层的。SpringMVC使用了适配器模式，前端控制器使用HandlerAdapter来调用不同的Controller,然后才是Controller调用Model产生数据模型; 
     产生的数据模型将会再次返回到前端控制器，并由前端控制器决定使用不同的模板引擎将页面进行渲染。   
3. Spring Bean的构造流程生命周期，构造中有参数和无参数的区别，优缺点，如何获取Bean对象
    
    **Bean的生命周期**

        1、Spring对Bean进行实例化；
        2、Spring将值和Bean的引用注入Bean对应的属性中；
        3、如果Bean实现了BeanNameAware接口，Spring将Bean的ID传递给setBeanName()接口方法；
        4、如果Bean实现了BeanFactoryAware接口，Spring将调用setBeanFactory()接口方法，将BeanFactory容器实例传入；
        5、如果Bean实现了ApplicationContextAware接口，Spring将调用setApplicationContext()接口方法，将应用上下文的引用传入；
        6、如果Bean实现了BeanPostProcessor接口，Spring将调用postProcessorBeforeInitialization()接口方法；
        7、如果Bean实现了InitializingBean接口，Spring将调用afterPropertiesSet()接口方法。如果Bean使用init-method声明了初始化方法，afterPropertiesSet()接口方法也会被调用；
        8、如果Bean实现了BeanPostProcessor接口，Spring将调用postProcessorAfterInitialization接口方法；
        9、到此时，Bean的初始化已经完成，可以被应用程序使用，并且Bean将一直驻留在应用上下文中，直到该应用上下文被销毁；
        10、如果Bean实现了DisposableBean接口，Spring将调用它的的destory()接口方法。如果Bean使用destory-method声明了销毁方法，destory()接口方法也会被调用；
        
    **Bean的获取** 
     
     Spring的容器可以分为两类：Bean工厂，应用上下文。可以通过Bean工厂或者应用上下文getBean()
     应用上下文也有多种类型：AnnotationConfigApplicationContext，AnnotationConfigWebApplicationContext
     ClassPathXmlApplicationContext，FileSystemXmlApplicationContext,XmlWebApplicationContext
     
        方法一：在初始化时保存ApplicationContext对象 
        方法二：通过Spring提供的utils类获取ApplicationContext对象 
        方法三：继承自抽象类ApplicationObjectSupport 
        方法四：继承自抽象类WebApplicationObjectSupport 
        方法五：实现接口ApplicationContextAware 
        方法六：通过Spring提供的ContextLoader
        
     **把bean交给 Spring 管理相比new的方式** 
     
      因为把对象生成放在了XML里定义，所以当我们需要换一个实现子类将会变成很简单（一般这样的对象都是现实于某种接口的），只要修改XML就可以了，
      这样我们甚至可以实现对象的热插拨（有点象USB接口和SCIS硬盘了）。 
      不需要了解实现类的创建方法。普通的 new 的方式需要你清楚的了解实现类的构造，如果在 new 
      的时候该实现类又又依赖了其他实现类，那需要学习的类就相对比较多了。bean交给 Spring 
      管理就不需要考虑这些东西，只需要直接获取即可。 
      编写完配置文件以后我们就可以直接使用bean了， Spring 是如何做到的？ 
      首先扫描配置文件，将bean放入 IOC 容器中，当使用的时候直接从 IOC 中取就可以了。 
      配置文件扫描 Spring 是如何做到的？ 使用专门处理 XML 的库。 
      你知道 Spring 处理 XML 用的是什么库吗？ org.xml.sax 
      你用过处理 XML 的库吗？  处理 XML 的库我目前知道的有两种，一种是 java 
      语言自带的库，另一种是JDOM，我在之前的一个系统中使用过JDOM来处理连接数据库的配置文件。 
      Spring 是如何获取对象的？  如果是单例模式的话，这个对象是在 Spring 配置文件扫描以后就直接建立好的，存放在 Map 中，用的时候直接从Map 中获取。 
      如果不是单例模式，反射调用构造器来 new 一个对象；   
      
      **构造中有参数和无参数的区别**
      
      若构造的方式需要有参数，可以尝试通过配置ApplicationConfig的方式getBean，自己去自定义Bean中的属性值，后面的就可以直接Autowire进去。
      或者通过配置XML而通常无参数的构造可以直接Autowire...
        
4. Spring IOC，DI，Spring的注入方式 
        
    依赖注入（Dependecy Injection）和控制反转（Inversion of Control）是同一个概念，具体的讲：当某个角色 
    需要另外一个角色协助的时候，在传统的程序设计过程中，通常由调用者来创建被调用者的实例。但在spring中 
    创建被调用者的工作不再由调用者来完成，因此称为控制反转。创建被调用者的工作由spring来完成，然后注入调用者 
    因此也称为依赖注入。 
    
    **注入的两种方式：设置注入和构造注入** 
    
    设置注入的优点：直观，自然 。设置注入就是指要被注入的类中定义有一个setter（）方法，并在参数中定义需要注入的对象。
    
        private String name ;  
        private int age ;  
        private String country ;  
        public String getName() {  
            return name;  
        }  
        public void setName(String name) {  
            this.name = name;  
        }  
        public int getAge() {  
            return age;  
        }  
        public void setAge(int age) {  
            this.age = age;  
        }  
        public String getCountry() {  
            return country;  
        }  
        public void setCountry(String country) {  
            this.country = country;  
        }  
        
    构造注入的优点：可以在构造器中决定依赖关系的顺序。 所谓构造注入就是指要被注入的类中声明一个构造方法，并在此方法的参数中定义要注入的对象。    
    
            private String name ;  
                private int age ;  
                private String country ;    
                public User(String name, int age, String country) {  
                    this.name = name;  
                    this.age = age;  
                    this.country = country;  
                }  
    
5. Spring的加载流程，容器加载，以及相关特性

    1. 首先，对于一个web应用，其部署在web容器中，web容器提供其一个全局的上下文环境，这个上下文就是ServletContext，其为后面的spring IoC容器提供宿主环境；
    
    2. 其 次，在web.xml中会提供有contextLoaderListener。在web容器启动时，会触发容器初始化事件，此时 contextLoaderListener会监听到这个事件，
    其contextInitialized方法会被调用，在这个方法中，spring会初始 化一个启动上下文，这个上下文被称为根上下文，即WebApplicationContext，这是
    一个接口类，确切的说，其实际的实现类是 XmlWebApplicationContext。这个就是spring的IoC容器，其对应的Bean定义的配置由web.xml中的
     context-param标签指定。在这个IoC容器初始化完毕后，spring以WebApplicationContext.ROOTWEBAPPLICATIONCONTEXTATTRIBUTE为属性Key，
     将其存储到ServletContext中，便于获取；
    3. 再 次，contextLoaderListener监听器初始化完毕后，开始初始化web.xml中配置的Servlet，这里是DispatcherServlet，这个servlet实际上是一个
    标准的前端控制器，用以转发、匹配、处理每个servlet请 求。DispatcherServlet上下文在初始化的时候会建立自己的IoC上下文，用以持有spring mvc
    相关的bean。在建立DispatcherServlet自己的IoC上下文时，会利用WebApplicationContext.ROOTWEBAPPLICATIONCONTEXTATTRIBUTE 先从
    ServletContext中获取之前的根上下文(即WebApplicationContext)作为自己上下文的parent上下文。有了这个 parent上下文之后，再初始化自己持有的
    上下文。这个DispatcherServlet初始化自己上下文的工作在其initStrategies方 法中可以看到，大概的工作就是初始化处理器映射、视图解析等。
    这个servlet自己持有的上下文默认实现类也是 mlWebApplicationContext。初始化完毕后，spring以与servlet的名字相关(此处不是简单的以servlet
    名为 Key，而是通过一些转换，具体可自行查看源码)的属性为属性Key，也将其存到ServletContext中，以便后续使用。这样每个servlet 就持有自己的上
    下文，即拥有自己独立的bean空间，同时各个servlet共享相同的bean，即根上下文(第2步中初始化的上下文)定义的那些 bean。
   
    **Spring 容器加载的方式有四种方式**
    1. 利用ServletContextListener 实现。
    2. 采用load-on-startup Servlet 实现。 
    3. 如果使用struts加载多个spring配置文件.
       下面这个配置的其实也是contextConfigLocation变量.struts-config.xml里面加这个<plug-in className="org.springframework.web.struts.ContextLoaderPlugIn"><set-property property="contextConfigLocation" value="/WEB-INF/applicationContext.xml,/WEB-INF/action-servlet.xml,,,,,,,"/>
    4. 如果是非j2ee应用直接程序加载.ApplicationContext act = new ClassPathXmlApplicationContext(new String[]{"bean1.xml","bean2.xml"});BeanDefinitionRegistry reg = new DefaultListableBeanFactory();XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(reg);reader.loadBeanDefinitions(new ClassPathResource("bean1.xml"));reader.loadBeanDefinitions(new ClassPathResource("bean2.xml"));BeanFactory bf = (BeanFactory)reg;   
6. Spring Security的实现，拦截器怎么用，Controller是单例的吗（默认单例）(重要！！！)

7. MyBatis与JDBC

        JDBC是Java提供的一个操作数据库的API； 
        MyBatis是一个支持普通SQL查询，存储过程和高级映射的优秀持久层框架。
        MyBatis消除了几乎所有的JDBC代码和参数的手工设置以及对结果集的检索封装。
        MyBatis可以使用简单的XML或注解用于配置和原始映射，将接口和Java的POJO（Plain Old Java Objects，普通的Java对象）映射成数据库中的记录。 
        MyBatis是对JDBC的封装。
        
    相对于JDBC，MyBatis有以下优点：
    1. 优化获取和释放
    
            我们一般在访问数据库时都是通过数据库连接池来操作数据库，数据库连接池有好几种，
            比如C3P0、DBCP，也可能采用容器本身的JNDI数据库连接池。我们可以通过DataSource
            进行隔离解耦，我们统一从DataSource里面获取数据库连接，DataSource具体由DBCP实
            现还是由容器的JNDI实现都可以，所以我们将DataSource的具体实现通过让用户配置来应
            对变化。
            
     2. SQL统一管理，对数据库进行存取操作
     
             我们使用JDBC对数据库进行操作时，SQL查询语句分布在各个Java类中，这样可读性差，不利
             于维护，当我们修改Java类中的SQL语句时要重新进行编译。Mybatis可以把SQL语句放在配置
             文件中统一进行管理，以后修改配置文件，也不需要重新就行编译部署。
     
     3. 生成动态SQL语句
     
             我们在查询中可能需要根据一些属性进行组合查询，比如我们进行商品查询，我们可以根据商品名称进
             行查询，也可以根据发货地进行查询，或者两者组合查询。如果使用JDBC进行查询，这样就需要写多条
             SQL语句。 Mybatis可以在配置文件中通过使用<if sms.test=””></if>标签进行SQL语句的拼接，生成动
             态SQL语句。     
               
      4. 能够对结果集进行映射
      
              我们在使用JDBC进行查询时，返回一个结果集ResultSet,我们要从结果集中取出结果封装为需要的类型
              在Mybatis中我们可以设置将结果直接映射为自己需要的类型，比如：JavaBean对象、一个Map、一个List
              等等。像上个例子中就是将结果映射为int类型。         
8. String、StringBuffer和StringBuilder的区别

    String 类型和StringBuffer的主要性能区别：String是不可变的对象（immutable）,用于存放
    字符的数组被声明为final的，因此只能赋值一次，不可再更改。 因此在每次对String 
    类型进行改变的时候，都会生成一个新的 String 对象，然后将指针指向新的 String 对象，
    所以经常改变内容的字符串最好不要用 String ，因为每次生成对象都会对系统性能产生影响，
    特别当内存中无引用对象多了以后， JVM 的 GC 就会开始工作，性能就会降低。
    使用 StringBuffer 类时，每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对
    象并改变对象引用。所以多数情况下推荐使用 StringBuffer ，特别是字符串对象经常改变的
    情况下。在某些特别情况下， String 对象的字符串拼接其实是被 Java Compiler 编译成了
     StringBuffer 对象的拼接，所以这些时候 String 对象的速度并不会比 StringBuffer 
     对象慢。**StringBuilder：字符串变量（非线程安全）。StringBuffer：字符串变量（Sy
     nchronized，即线程安全）**
     
9. servlet是单例多线程，以及多线程下如何保证线程安全

    1、servlet是单例的，严格地说是一个**ServletMapping**对应一个单例实例(如果一个Servlet被映射了两个URL地址，会生成两个实例)。
    早期的CGI模式是原型式的，例如同时并发2000次请求一个Servlet，如果不是单例的，内存瞬间要创建2000个对象，同时为了线程安全
    还得阻塞对方线程，其性能非常之差。
    
    2、要维护Servlet线程安全有很多办法，通常是使用**同步块(或方法)来保护共享数据**，其次可以**volatile、Lock一些锁机制**，
    还可以使用**ThreadLocal来打通安全通道**，另外还有**原子操作**也是用来保护数据安全，有非常多的选择。
