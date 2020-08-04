# tutorial-java-basic（Java相关工具、方法集合）

- wsimport方式生成webservice客户端代码<br>
`wsimport -s d:\download\wsdl\ -keep -p com.stock -verbose -Xnocompile http://www.webxml.com.cn/WebServices/StockInfoWS.asmx?wsdl`
  - `-d` 生成客户端执行类的class文件的存放目录
  - `-s` 生成客户端执行类的源文件的存放目录
  - `-keep` 表示导出webservice的class文件时是否也导出源代码java文件
  - `-p` 定义生成类的包名
  - `-verbose` 显示生成过程
  - `-Xnocompile` 取消生成class文件

- git fork同步其它仓库最新代码  
 1.添加远程资源 `git remote add upstream http://xxx/xxx.git`  
 2.拉取分支信息 `git fetch upstream`
 3.更新分支信息 `git merge upstream/dev develop`
 4.推送代码 `git push origin develop`
