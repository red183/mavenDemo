SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

--DROP INDEX cms_article_create_by ON cms_article;
--DROP INDEX cms_article_title ON cms_article;
--DROP INDEX cms_article_keywords ON cms_article;
--DROP INDEX cms_article_del_flag ON cms_article;
--DROP INDEX cms_article_weight ON cms_article;
--DROP INDEX cms_article_update_date ON cms_article;
--DROP INDEX cms_article_category_id ON cms_article;
--DROP INDEX cms_category_parent_id ON cms_category;
--DROP INDEX cms_category_parent_ids ON cms_category;
--DROP INDEX cms_category_module ON cms_category;
--DROP INDEX cms_category_name ON cms_category;
--DROP INDEX cms_category_sort ON cms_category;
--DROP INDEX cms_category_del_flag ON cms_category;
--DROP INDEX cms_category_office_id ON cms_category;
--DROP INDEX cms_category_site_id ON cms_category;
--DROP INDEX cms_comment_category_id ON cms_comment;
--DROP INDEX cms_comment_content_id ON cms_comment;
--DROP INDEX cms_comment_status ON cms_comment;
--DROP INDEX cms_guestbook_del_flag ON cms_guestbook;
--DROP INDEX cms_link_category_id ON cms_link;
--DROP INDEX cms_link_title ON cms_link;
--DROP INDEX cms_link_del_flag ON cms_link;
--DROP INDEX cms_link_weight ON cms_link;
--DROP INDEX cms_link_create_by ON cms_link;
--DROP INDEX cms_link_update_date ON cms_link;
--DROP INDEX cms_site_del_flag ON cms_site;



/* Drop Tables */

DROP TABLE IF EXISTS cms_article_data;
DROP TABLE IF EXISTS cms_article;
DROP TABLE IF EXISTS cms_comment;
DROP TABLE IF EXISTS cms_link;
DROP TABLE IF EXISTS cms_picture;
DROP TABLE IF EXISTS cms_category;
DROP TABLE IF EXISTS cms_guestbook;
DROP TABLE IF EXISTS cms_site;




/* Create Tables */

-- 文章表
CREATE TABLE cms_article
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 栏目编号
	category_id varchar(64) NOT NULL COMMENT '栏目编号',
	-- 标题
	title varchar(255) NOT NULL COMMENT '标题',
	-- 文章链接
	link varchar(255) COMMENT '文章链接',
	-- 标题颜色（red：红色；green：绿色；blue：蓝色；yellow：黄色；orange：橙色）
	color varchar(50) COMMENT '标题颜色（red：红色；green：绿色；blue：蓝色；yellow：黄色；orange：橙色）',
	-- 文章图片
	image varchar(255) COMMENT '文章图片',
	-- 关键字
	keywords varchar(255) COMMENT '关键字',
	-- 描述、摘要
	description varchar(255) COMMENT '描述、摘要',
	-- 权重，越大越靠前
	weight int DEFAULT 0 COMMENT '权重，越大越靠前',
	-- 权重期限，过期后将权重设置为：0
	weight_date datetime COMMENT '权重期限，过期后将权重设置为：0',
	-- 点击数
	hits int DEFAULT 0 COMMENT '点击数',
	-- 推荐位，多选（1：首页焦点图；2：栏目页文章推荐；）
	posid varchar(10) COMMENT '推荐位，多选（1：首页焦点图；2：栏目页文章推荐；）',
	custom_content_view varchar(255),
	view_config text,
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	del_flag char(1) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = MyISAM COMMENT = '文章表' DEFAULT CHARACTER SET utf8;


-- 文章详表
CREATE TABLE cms_article_data
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 文章内容
	content text COMMENT '文章内容',
	-- 文章来源
	copyfrom varchar(255) COMMENT '文章来源',
	-- 相关文章
	relation varchar(255) COMMENT '相关文章',
	-- 是否允许评论
	allow_comment char(1) COMMENT '是否允许评论',
	PRIMARY KEY (id)
) ENGINE = MyISAM COMMENT = '文章详表' DEFAULT CHARACTER SET utf8;


-- 栏目表
CREATE TABLE cms_category
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 父级编号
	parent_id varchar(64) NOT NULL COMMENT '父级编号',
	-- 所有父级编号
	parent_ids varchar(2000) NOT NULL COMMENT '所有父级编号',
	-- 站点编号
	site_id varchar(64) DEFAULT '1' COMMENT '站点编号',
	-- 归属机构
	office_id varchar(64) COMMENT '归属机构',
	-- 栏目模块（article：文章；picture：图片；download：下载；link：链接；special：专题）
	module varchar(20) COMMENT '栏目模块（article：文章；picture：图片；download：下载；link：链接；special：专题）',
	-- 栏目名称
	name varchar(100) NOT NULL COMMENT '栏目名称',
	-- 栏目图片
	image varchar(255) COMMENT '栏目图片',
	-- 链接
	href varchar(255) COMMENT '链接',
	-- 目标（ _blank、_self、_parent、_top）
	target varchar(20) COMMENT '目标（ _blank、_self、_parent、_top）',
	-- 描述，填写有助于搜索引擎优化
	description varchar(255) COMMENT '描述，填写有助于搜索引擎优化',
	-- 关键字，填写有助于搜索引擎优化
	keywords varchar(255) COMMENT '关键字，填写有助于搜索引擎优化',
	-- 排序（升序）
	sort int DEFAULT 30 COMMENT '排序（升序）',
	-- 是否在导航中显示（1：显示；0：不显示）
	in_menu char(1) DEFAULT '1' COMMENT '是否在导航中显示（1：显示；0：不显示）',
	-- 是否在分类页中显示列表（1：显示；0：不显示）
	in_list char(1) DEFAULT '1' COMMENT '是否在分类页中显示列表（1：显示；0：不显示）',
	-- 展现方式（0:有子栏目显示栏目列表，无子栏目显示内容列表;1：首栏目内容列表；2：栏目第一条内容）
	show_modes char(1) DEFAULT '0' COMMENT '展现方式（0:有子栏目显示栏目列表，无子栏目显示内容列表;1：首栏目内容列表；2：栏目第一条内容）',
	-- 是否允许评论
	allow_comment char(1) COMMENT '是否允许评论',
	-- 是否需要审核
	is_audit char(1) COMMENT '是否需要审核',
	-- 自定义列表视图
	custom_list_view varchar(255) COMMENT '自定义列表视图',
	-- 自定义内容视图
	custom_content_view varchar(255) COMMENT '自定义内容视图',
	view_config text,
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	del_flag char(1) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = MyISAM COMMENT = '栏目表' DEFAULT CHARACTER SET utf8;


-- 评论表
CREATE TABLE cms_comment
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 栏目编号
	category_id varchar(64) NOT NULL COMMENT '栏目编号',
	-- 栏目内容的编号（Article.id、Photo.id、Download.id）
	content_id varchar(64) NOT NULL COMMENT '栏目内容的编号（Article.id、Photo.id、Download.id）',
	-- 栏目内容的标题（Article.title、Photo.title、Download.title）
	title varchar(255) COMMENT '栏目内容的标题（Article.title、Photo.title、Download.title）',
	-- 评论内容
	content varchar(255) COMMENT '评论内容',
	-- 评论姓名
	name varchar(100) COMMENT '评论姓名',
	-- 评论IP
	ip varchar(100) COMMENT '评论IP',
	-- 评论时间
	create_date datetime NOT NULL COMMENT '评论时间',
	-- 审核人
	audit_user_id varchar(64) COMMENT '审核人',
	-- 审核时间
	audit_date datetime COMMENT '审核时间',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) ENGINE = MyISAM COMMENT = '评论表' DEFAULT CHARACTER SET utf8;


-- 留言板
CREATE TABLE cms_guestbook
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 留言分类（1咨询、2建议、3投诉、4其它）
	type char(1) NOT NULL COMMENT '留言分类（1咨询、2建议、3投诉、4其它）',
	-- 留言内容
	content varchar(255) NOT NULL COMMENT '留言内容',
	-- 姓名
	name varchar(100) NOT NULL COMMENT '姓名',
	-- 邮箱
	email varchar(100) NOT NULL COMMENT '邮箱',
	-- 电话
	phone varchar(100) NOT NULL COMMENT '电话',
	-- 单位
	workunit varchar(100) NOT NULL COMMENT '单位',
	-- IP
	ip varchar(100) NOT NULL COMMENT 'IP',
	-- 留言时间
	create_date datetime NOT NULL COMMENT '留言时间',
	-- 回复人
	re_user_id varchar(64) COMMENT '回复人',
	-- 回复时间
	re_date datetime COMMENT '回复时间',
	-- 回复内容
	re_content varchar(100) COMMENT '回复内容',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) ENGINE = MyISAM COMMENT = '留言板' DEFAULT CHARACTER SET utf8;


-- 友情链接
CREATE TABLE cms_link
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 栏目编号
	category_id varchar(64) NOT NULL COMMENT '栏目编号',
	-- 链接名称
	title varchar(255) NOT NULL COMMENT '链接名称',
	-- 标题颜色（red：红色；green：绿色；blue：蓝色；yellow：黄色；orange：橙色）
	color varchar(50) COMMENT '标题颜色（red：红色；green：绿色；blue：蓝色；yellow：黄色；orange：橙色）',
	-- 链接图片，如果上传了图片，则显示为图片链接
	image varchar(255) COMMENT '链接图片，如果上传了图片，则显示为图片链接',
	-- 链接地址
	href varchar(255) COMMENT '链接地址',
	-- 权重，越大越靠前
	weight int DEFAULT 0 COMMENT '权重，越大越靠前',
	-- 权重期限，过期后将权重设置为：0
	weight_date datetime COMMENT '权重期限，过期后将权重设置为：0',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	del_flag char(1) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = MyISAM COMMENT = '友情链接' DEFAULT CHARACTER SET utf8;


CREATE TABLE cms_picture
(
	-- 主键
	id varchar(64) NOT NULL COMMENT '主键',
	-- 栏目编号
	category_id varchar(64) NOT NULL COMMENT '栏目编号',
	-- 标题
	name varchar(50) COMMENT '标题',
	-- 图片描述
	description varchar(2000) COMMENT '图片描述',
	-- 小型图片
	image_small varchar(255) COMMENT '小型图片',
	-- 中型图片
	image_medium varchar(255) COMMENT '中型图片',
	-- 大型图片
	image_large varchar(255) COMMENT '大型图片',
	-- 扩展图片1
	image_ex1 varchar(255) COMMENT '扩展图片1',
	-- 扩展图片2
	image_ex2 varchar(255) COMMENT '扩展图片2',
	-- 扩展图片3
	image_ex3 varchar(255) COMMENT '扩展图片3',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	del_flag char(1) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = MyISAM DEFAULT CHARACTER SET utf8;


-- 站点表
CREATE TABLE cms_site
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 站点名称
	name varchar(100) NOT NULL COMMENT '站点名称',
	-- 站点标题
	title varchar(100) NOT NULL COMMENT '站点标题',
	-- 站点Logo
	logo varchar(255) COMMENT '站点Logo',
	-- 站点域名
	domain varchar(255) COMMENT '站点域名',
	-- 描述，填写有助于搜索引擎优化
	description varchar(255) COMMENT '描述，填写有助于搜索引擎优化',
	-- 关键字，填写有助于搜索引擎优化
	keywords varchar(255) COMMENT '关键字，填写有助于搜索引擎优化',
	-- 主题
	theme varchar(255) DEFAULT 'default' COMMENT '主题',
	-- 版权信息
	copyright text COMMENT '版权信息',
	-- 自定义站点首页视图
	custom_index_view varchar(255) COMMENT '自定义站点首页视图',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	del_flag char(1) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = MyISAM COMMENT = '站点表' DEFAULT CHARACTER SET utf8;



/* Create Foreign Keys */

ALTER TABLE cms_article_data
	ADD FOREIGN KEY (id)
	REFERENCES cms_article (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cms_article
	ADD FOREIGN KEY (category_id)
	REFERENCES cms_category (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cms_comment
	ADD FOREIGN KEY (category_id)
	REFERENCES cms_category (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cms_link
	ADD FOREIGN KEY (category_id)
	REFERENCES cms_category (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cms_picture
	ADD FOREIGN KEY (category_id)
	REFERENCES cms_category (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cms_category
	ADD FOREIGN KEY (site_id)
	REFERENCES cms_site (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Indexes */

--CREATE INDEX cms_article_create_by ON cms_article ();
--CREATE INDEX cms_article_title ON cms_article ();
--CREATE INDEX cms_article_keywords ON cms_article ();
--CREATE INDEX cms_article_del_flag ON cms_article ();
--CREATE INDEX cms_article_weight ON cms_article ();
--CREATE INDEX cms_article_update_date ON cms_article ();
--CREATE INDEX cms_article_category_id ON cms_article ();
--CREATE INDEX cms_category_parent_id ON cms_category ();
--CREATE INDEX cms_category_parent_ids ON cms_category ();
--CREATE INDEX cms_category_module ON cms_category ();
--CREATE INDEX cms_category_name ON cms_category ();
--CREATE INDEX cms_category_sort ON cms_category ();
--CREATE INDEX cms_category_del_flag ON cms_category ();
--CREATE INDEX cms_category_office_id ON cms_category ();
--CREATE INDEX cms_category_site_id ON cms_category ();
--CREATE INDEX cms_comment_category_id ON cms_comment ();
--CREATE INDEX cms_comment_content_id ON cms_comment ();
--CREATE INDEX cms_comment_status ON cms_comment ();
--CREATE INDEX cms_guestbook_del_flag ON cms_guestbook ();
--CREATE INDEX cms_link_category_id ON cms_link ();
--CREATE INDEX cms_link_title ON cms_link ();
--CREATE INDEX cms_link_del_flag ON cms_link ();
--CREATE INDEX cms_link_weight ON cms_link ();
--CREATE INDEX cms_link_create_by ON cms_link ();
--CREATE INDEX cms_link_update_date ON cms_link ();
--CREATE INDEX cms_site_del_flag ON cms_site ();



