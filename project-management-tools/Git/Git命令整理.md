# Git常用命令
* [参考学习链接](https://www.cnblogs.com/specter45/p/github.html)
* git config --global user.name "Your_username" 修改全局账号名
* git config --global user.email "Your_email" 修改全局邮箱
* git config user.name 查看当前登陆账号
* git config user.email 查看当前登陆邮箱
* git init //把这个目录变成Git可以管理的仓库
* git add README.md //文件添加到仓库
* git add . //不但可以跟单一文件，还可以跟通配符，更可以跟目录。一个点就把当前目录下所有未追踪的文件全部add了 
* git commit -m "first commit" //把文件提交到仓库
* git remote add origin git@github.com:wangjiax9/practice.git //关联远程仓库
* git push -u origin master //把本地库的所有内容推送到远程库上