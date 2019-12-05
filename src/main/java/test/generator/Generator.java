package test.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 自动生成
 * @author: zhangshuai
 * @create: 2019-09-25 11:45
 */
public class Generator {


    //作者
    private static String authorName = "zhangshuai";

    //要生成的表名
    private static String[] tables = {"bif_dispatch_hr_service_area"};



    //----------------------------------------------下面不要管--------------------------------------------------------------

    //table前缀
//    private static String prefix = "trc_";

    //数据库配置四要素
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://rm-k5qcpzc24x9e2fo953o.mysql.rds.aliyuncs.com/core_center_test";
    private static String username = "db_user";
    private static String password = "Teekee123";


    //项目路径
    private static String canonicalPath = "";

    //基本包名
    private static String basePackage = "com.example.generator";


    public static void main(String[] args) {

        AutoGenerator gen = new AutoGenerator();

        /**
         * 获取项目路径
         */
        try {
            canonicalPath = new File("").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         * 数据库配置
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setUrl(url);
        gen.setDataSource(dsc);


        /**
         * 全局配置
         */
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(canonicalPath + "/src/main/java");
        gc.setAuthor(authorName);
        gc.setFileOverride(true); //是否覆盖
        gc.setActiveRecord(true);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setSwagger2(true);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
         gc.setMapperName("%sMapper");
         gc.setXmlName("%sMapper");
//         gc.setServiceName("MP%sService");
         gc.setServiceImplName("%sService");
         gc.setControllerName("%sController");
        gen.setGlobalConfig(gc);

        /**
         * 策略配置
         */
        StrategyConfig strategy = new StrategyConfig();
         strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
//        strategy.setTablePrefix(new String[]{prefix});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
         strategy.setInclude(tables); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
         strategy.setSuperEntityClass("com.example.generator.base.BaseEntity");
        // 自定义实体，公共字段
//         strategy.setSuperEntityColumns("id");
        // 自定义 mapper 父类
         strategy.setSuperMapperClass("com.example.generator.base.BaseMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
         strategy.setSuperServiceImplClass("com.example.generator.base.BaseService");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        strategy.setEntityBuilderModel(true);
        gen.setStrategy(strategy);



        /**
         * 包配置
         */
        PackageConfig pc = new PackageConfig();
        pc.setParent(basePackage);  // 自定义包路径
//        pc.setModuleName("warrior");
        pc.setController("controler"); // 这里是控制器包名，默认 web
        pc.setEntity("entity");  // 设置Entity包名，默认entity
        pc.setMapper("mapper");   // 设置Mapper包名，默认mapper
//        pc.setService("service");   // 设置Service包名，默认service
        pc.setServiceImpl("service");  // 设置Service Impl包名，默认service.impl
        pc.setXml("mapper");  // 设置Mapper XML包名，默认mapper.xml
        gen.setPackageInfo(pc);


        /**
         * 注入自定义配置
         */
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig abc = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //自定义文件输出位置（非必须）
        List<FileOutConfig> fileOutList = new ArrayList<FileOutConfig>();
        fileOutList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return canonicalPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        abc.setFileOutConfigList(fileOutList);
        gen.setCfg(abc);

        /**
         * 指定模板引擎 默认是VelocityTemplateEngine ，需要引入相关引擎依赖
         */
        //gen.setTemplateEngine(new FreemarkerTemplateEngine());

        /**
         * 模板配置
         */
        TemplateConfig templateConfig = new TemplateConfig();
        // 关闭默认 xml 生成，调整生成 至 根目录
        templateConfig.setXml(null);
        // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
        // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
//        templateConfig.setController("...");
//        templateConfig.setEntity("...");
//        templateConfig.setMapper("...");
        templateConfig.setService(null);
//        templateConfig.setServiceImpl("...");

        gen.setTemplate(templateConfig);

        // 执行生成
        gen.execute();
    }

}
