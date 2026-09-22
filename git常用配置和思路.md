
## idea上配置连接github仓库的方法
### 方法1：免每次输入令牌操作
```
ssh-keygen -t ed25519 -C "786637288@qq.com"
没有写入密码
配置电脑上任何 git 仓库提交，默认都会用这个身份
git config --global user.name "JN-Fahrenheit"
git config --global user.email "786637288@qq.com"
```
### 方法2：配置token
在 GitHub 网页生成 Token（需勾选 repo 权限），粘贴到 IDEA 中即可完成认证

## 关于idea上的功能按钮
- IDEA"Share Project on GitHub" 功能的设计机制问题，会无法自定义选择文件
这个功能本质是一个 "一键分享整个项目" 的快捷入口，内部流程是固定的：
1. 自动在项目根目录 `git init`
2. 自动 `git add .` —— 把**所有未被 `.gitignore` 排除的文件**全部加入暂存区
3. 自动创建初始 commit
4. 在 GitHub 建仓库并 push

## 其他操作 
1. 如果需排除上传文件，可以在.gitigore上新增相关文件
2. 查看当前远程地址：顶部菜单 `Git → Manage Remotes...`（旧版在 `VCS → Git → Remotes`）

## 其他问题
- 问题现象：已在idea上打算分享项目后点击"Share Project on GitHub" 功能，想将二次上传的特殊文件禁用却失败
- 原因：因为 `PROMPT.md` 和 `SKILL.md` 之前已经被 git 追踪过了，光靠 `.gitignore` 拦不住它们。必须先让它们变成 "未被追踪" 状态，再重新提交推送:初始化git仓库，完成提交推送过程
1. 删除旧的 git 仓库（清除历史）
```
Remove-Item -Recurse -Force .git
```
2. 确认.gitignore下有排除上传的文件
3. 重新初始化 git 并提交（此时 `.gitignore` 才真正生效）
```
git init
git add .
git status #对应文件不在当前列表下
```
4. 确认后，提交并切换分支
```
git commit -m "Init: XmindToTestCases skill 思维导图转测试用例"
git branch -M main
```
5. 上传到 GitHub（两种方式任选）
    1. idea上Share Project on GitHub---方式不稳定
    2. 推荐：命令行推送（更可控）
    - 先去 GitHub 网页新建一个空仓库（不要勾选初始化 README）
    - 回到终端执行：
    ```
    git remote add origin git@github.com:JN-Fahrenheit/api_autotest_demo
    git push -u origin main
    ```

## 清除旧缓存记录的命令
```aiignore
git rm --cached -r .
```