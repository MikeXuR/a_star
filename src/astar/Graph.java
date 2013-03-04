/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package astar;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author akshay
 */
public class Graph {
    public List<node> nodes;
    public List<edge> edges;
    public int edge_count;
    public int node_count;
    HashMap<node,Integer> heuristic_map;
    HashMap<edge,Integer> weight_map;
    Graph(List<node> n,List<edge> e)
    {
        nodes=n;
        edges=e;
    }
    Graph()
    {
        nodes=new ArrayList<node>();
        edges=new ArrayList<edge>();
        heuristic_map=new HashMap<node,Integer>();
        weight_map = new HashMap<edge, Integer>();
    }
    public node getNodeByNum(int n_num)
    {
        Iterator it=nodes.iterator();
        node n;
        while(it.hasNext())
        {
            n=(node)it.next();
            if( n.num==n_num)
            {
                return n;
            }
        }
        n=new node(-1);
        return n;
    }
    public List<listNode> getNeighbours(listNode n)
    {
        List<listNode> l;
        l= new ArrayList<listNode>();
        Iterator it=edges.iterator();
        edge temp;
        listNode ln;
        while(it.hasNext())
        {
            temp=(edge)it.next();
            if((temp.node1).num==(n.n).num)
            {
                ln=new listNode(temp.node2,temp.weight+n.g_score);
                l.add(ln);
            }
            else if((temp.node2).num==(n.n).num)
            {
                ln=new listNode(temp.node1,temp.weight+n.g_score);
                l.add(ln);
            }
        }
        return l;
    }
   public edge addEdge(int w,int src,int dst){
       node m = new node(src);
       node n = new node(dst);
       edge e = new edge(w,m,n);
       edges.add(e);
       weight_map.put(e,w);
       return e;
   }
   public edge addEdge(int w,node src,node dst){
       edge e = new edge(w,src,dst);
       edges.add(e);
       weight_map.put(e,w);
       return e;
   }
   public void add_heuristic_cost_estimate(node n,node goal,int val){
        heuristic_map.put(n,new Integer(val));
    }
   public int heuristic_cost_estimate(node n){
       return heuristic_map.get(n);
   }
   public int getWeight(node src,node dst){
       edge e = new edge(0,src,dst);
       edge tmp;
       int w=0;
       Iterator it=edges.iterator();
       while(it.hasNext()){
         tmp = (edge)it.next();
         if(tmp==e){w=tmp.weight;break;}
       }
       return w;
   }
}
