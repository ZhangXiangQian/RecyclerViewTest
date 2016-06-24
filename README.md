# RecyclerViewTest
   RecyclerView实现ListView、GridView、瀑布流效果
RecyclerView是谷歌退出的最新的替换listView和GridView也可以实现瀑布流的效果，RecyclerView重点放在布局的复用，具体的布局交给LayoutManager来处理
   若要使用该控件需要导入android.support.v7.widget.RecyclerView包
###RecyclerView.ViewHolder
 之前优化ListView时一般也需要我们自己来写ViewHolder，在RecyclerView中谷歌提供了一个新的类RecyclerView.ViewHolder
 
```java
     public static class RecyForListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_content;
        View itemView;
        //Item布局
        public RecyForListViewHolder(View itemView) {
            super(itemView);
            //布局中的控件在这里初始化
            this.itemView = itemView;
        }
    }
```

###RecyclerView.Adapter<(这里传入自定义的ViewHolder的子类)>(适配器)
```java
 public class RecyForStaggeredAdapter extends RecyclerView.Adapter<RecyForStaggeredAdapter.RecyForList> implements View.OnClickListener {
    private RecyForListClickListener listener;
    Context context;

    private int[] dd = new int[]{R.drawable.h1438342866771, R.drawable.h1453679686433_1459497492682, R.drawable.h1453679686433_1459497492682,
            R.drawable.h1453679686433_1459497492682
            , R.drawable.h1465209662128, R.drawable.h1463889990992};
            
    //这里返回我们重新的ViewHolder的对象即可
    @Override
    public RecyForListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_item, parent, false);
        //将我们自定义的布局传入
        return new RecyForListViewHolder(v);
    }
    //数据绑定
    @Override
    public void onBindViewHolder(RecyForList holder, int position) {
        holder.itemView.setBackground(context.getResources().getDrawable(dd[position]));
    }
   //item的个数
    @Override
    public int getItemCount() {
       //这里同listView就没多大区别 view的多少
        return dd.length;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onRecyForListClickListener();
        }
    }
}
```
###类ListView效果
  谷歌提供了三种常用布局管理器LinearLayoutManager实现的就如ListView效果
 ```java
   LinearLayoutManager manager = new LinearLayoutManager(this);
    RecyclerView mRecyclerView.setLayoutManager(manager);
 ```
###类GridView效果
  谷歌提供了三种常用布局管理器LinearLayoutManager实现的就如ListView效果
 ```java
    GridLayoutManager manager = new GridLayoutManager(this ,3); //第二个参数每行显示的item的个数
    RecyclerView mRecyclerView.setLayoutManager(manager);
 ```
###瀑布流效果
  谷歌提供了三种常用布局管理器LinearLayoutManager实现的就如ListView效果
 ```java
    //第一个参数每行显示的item的个数，第二个参数瀑布流的风格
    StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL); 
    RecyclerView mRecyclerView.setLayoutManager(manager);
 ```
 
