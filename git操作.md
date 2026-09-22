# 公司层代码提交方式
## 背景
- 在公司团队上，团队共用同一个 origin 仓库，不搞 Fork。所有人都 `git clone` 同一份代码。
	1. main（或 dev）是受保护分支：默认禁止任何人直接 push，想进代码必须走 Merge Request（GitLab）/ Pull Request（GitHub），至少一名 reviewer 审核通过才能合并。这就是为什么只能 push 自己的分支代码，不能 push main。
	2. 每个人建自己的分支 → push 分支 → 提 MR → review → 合并。分支互不干扰，合并进 main 后，其他同事 `git pull` 就能拿到你的代码。
- 在开源项目上
	- 不能直接 push 原仓库，要先 Fork 一份到自己账号下，改完往原仓库发 Pull Request
## 命令示例背景说明
```
pull = fetch + merge 从远程主机的master分支拉取最新内容+将拉取下来的最新内容合并到当前所在的分支中
git log 命令显示从最近到最远的提交日志

orgin:仓库名
main或master：主分支名
feature/xxx：本地分支名
```

## 实际操作
1. 安装git 个人账号在 gitlab/github 上增加 ssh key
2. 拉取代码
```
git clone "git@git.mailtech.cn:autotest/cmweb-xt7.git" 
```
3. 创建个人分支(分支基于最新代码)【idea右下角直接勾选checkout自动切换】
```
# 拉取远端最新代码
git fetch origin 
git pull origin main
# 基于main新建并切换到功能分支
git checkout -b feature/xxx origin/main
```
4. 开发并提交，commit前暂存代码内容，commit附带信息【IDEA 默认对勾选文件自动 stage，等效 git add。】
```
# 查看哪些文件改动或冲突，当前变更的文件和状态
git status
# 添加改动文件到暂存区(staged)
git add .
# 提交代码在本地分支，写清晰提交备注
git commit -m "feat:新增xxx用例"
```
5. 重新先同步目标分支最新代码，避免直接push造成MR冲突
	1. 下载远程更新保持一致
	```
	# 更新本地这份 `origin/main` 快照，做一遍安全预览初步确定
	git fetch origin
	# 切换到本地main分支
	git checkout main
 	# 可选，查看远程有哪些新提交
 	git log --oneline --graph main..origin/main — 查看远程有哪些新提交
	# 远程最新代码合并到本地的main分支，等于拉取+变基；--rebase 只是把"合并方式"从 merge 换成 rebase 
	git pull --rebase origin main   
	```
	2. 切回个人分支，把个人提交重放到最新 dev 之上（即"重新 rebase"），让代码保持1条直线
	```
	git checkout feature/xxx
	git rebase origin/main # 等于只是变基
	```
	3.  (可选) 若有冲突
	```
	git staus # 看哪些文件冲突
	# 打开文件手动改好冲突
	git add . && git rebase --continue # 解完一个继续下一个
	# 不想解了：git rebase --abort 回到原样
	```
6. 推送个人分支到远端git仓库
```
git push -u origin feature/xxx # 可选，针对首次推送，从没 push 过的情况
git push --force-with-lease   # 可选，针对分支之前 push 过的情况；必须带 --force-with-lease
```
7、发起 Merge Request 等待合并，在 git.mailtech.cn 网页 New Merge Request：源分支=个人分支，目标分支=main/develop（按团队约定），填标题/描述、关联需求单号、指派 review 人。
8、合并完成后由审核人删除分支

# 个人代码上传github操作

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
1、IDEA"Share Project on GitHub" 功能的设计机制问题，会无法自定义选择文件
这个功能本质是一个 "一键分享整个项目" 的快捷入口，内部流程是固定的：
1. 自动在项目根目录 `git init`
2. 自动 `git add .` —— 把**所有未被 `.gitignore` 排除的文件**全部加入暂存区
3. 自动创建初始 commit
4. 在 GitHub 建仓库并 push

## 其他操作 
1. 如果需排除上传文件，可以在.gitigore上新增相关文件
2. 查看当前远程地址：顶部菜单 `Git → Manage Remotes...`（旧版在 `VCS → Git → Remotes`）

## 过程问题
- 现象：已在idea上打算分享项目后点击"Share Project on GitHub" 功能，想将二次上传的特殊文件禁用却失败
- 原因：因为 `PROMPT.md` 和 `SKILL.md` 之前已经被 git 追踪过了，光靠 `.gitignore` 拦不住它们。必须先让它们变成 "未被追踪" 状态，再重新提交推送:初始化git仓库，完成提交推送过程

1、删除旧的 git 仓库（清除历史）
```
Remove-Item -Recurse -Force .git
```
2、确认.gitignore下有排除上传的文件
3、重新初始化 git 并提交（此时 `.gitignore` 才真正生效）
```
git init
git add .
git status #对应文件不在当前列表下
```
4、确认后，提交并切换分支
```
git commit -m "Init: XmindToTestCases skill 思维导图转测试用例"
git branch -M main
```
5、上传到 GitHub（两种方式任选）
5.1、idea上Share Project on GitHub---方式不稳定
5.2、推荐：命令行推送（更可控）
a、先去 GitHub 网页新建一个空仓库（不要勾选初始化 README）
b、回到终端执行：
```
git remote add origin git@github.com:JN-Fahrenheit/api_autotest_demo
git push -u origin main
```


