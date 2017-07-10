# JsPopupWindow
## 将PopupWindow封装，避免重复代码; 采用建造者模式
## 特将代码整理传至github，大家多star

## 效果
![img](https://github.com/shuaijia/JsPopupWindow/blob/master/gif/GIF.gif)

## step 1：
```java
allprojects {
    repositories {
        ...
        maven { url 'https://www.jitpack.io' }
    }
}
  
dependencies {
    compile 'com.github.shuaijia:JsPopupWindow:1.0'
}
```
## 使用
```java
JsPopupWindow popWindow = new JsPopupWindow.Builder()
                .setContentViewId(R.layout.dialog_popupwindow) // 设置布局
                .setContext(MainActivity.this) // 设置上下文
                .setOutSideCancle(true) // 点击外部消失
                .setHeight(LinearLayout.LayoutParams.WRAP_CONTENT) // 设置高度
                .setWidth(LinearLayout.LayoutParams.WRAP_CONTENT) // 设置宽度
                .setAnimation(R.style.anim_pop) // 设置动画
                .build() // 构建
                .showAtLocation(rl_pop_root, Gravity.TOP | Gravity.CENTER, 0, 0); // 必须在build之后，显示popupWindow

// 获取子控件
TextView tv_pop= (TextView) popWindow.getItemView(R.id.tv_pop);
tv_pop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,"PopupWindow的Item点击",Toast.LENGTH_LONG).show();
    }
});
```
## 注意：showAtLocation()是在某布局内展示，showAsLocation()是相对于某View外的位置展示，它们必须在build()方法之后调用。
## 欢迎骚扰 819418850@qq.com
