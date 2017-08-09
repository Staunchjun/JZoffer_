# 汇总(面试回答版)

1. 由Spring AOP引申出来的动态代理知识。（AOP的思想，Spring Aop如何设计与实现，aop事务的隔离级别和传播特性，aop切面的功能 和继承的关系 ，jdk动态代理和cglib动态代理什么区别，SpringAOP用的哪一种代理（都有用到） ）

    AOP是一种“面向切面编程”。可以通过预编译方式和运行期动态代理实现在不修改源代码的情况下给程序动态统一添加功能的一种技术。AOP主要用于日志记录，性能统计，安全控制，事务处理（说到事务处理就会提到aop事务的隔离级别和传播特性），异常处理等等wn及扩展。
     
    Spring Aop如何设计与实现是基于动态代理的方式：
    
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
     1. 需求->在原有
     2. 实现
    ---
   **下面是又AOP谈到事务处理作用衍生出来的数据库问题**
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
   
