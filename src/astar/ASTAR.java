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
public class ASTAR {
     private List<listNode> openList;
    private List<listNode> closedList;
   //private HashMap<node,node> hm;
    public ASTAR(){
        openList= new ArrayList<listNode>();
        closedList= new ArrayList<listNode>();
    }
    public void findBestPath(node source,node goal)
    {
        openList= new ArrayList<listNode>();
        closedList= new ArrayList<listNode>();
        //node s=source;
        //node g=goal;
        listNode lnode=new listNode(source,null,0);
        openList.add(lnode);
        listNode selected_n=new listNode();
        listNode temp_n;
        int min=-1,sel_ind=0,temp_ind;
        int f_score;
        List<listNode> neighbourList;
        while(!openList.isEmpty())
        {
            min=-1;
            temp_ind=0;
            Iterator it=openList.iterator();
            while(it.hasNext())  // selecting the minimum fscore node to expand
            {
                
                    temp_n=(listNode)it.next();
                    f_score=temp_n.g_score+(temp_n.n).heuristic(goal);
                    if(min<0||f_score<min)
                    {
                        min=f_score;
                        selected_n=temp_n;  //node to be expanded
                        sel_ind=temp_ind;
                    }
                    temp_ind++;
            }
            if((selected_n.n).equals(goal))
            {
                closedList.add(selected_n);
                System.out.println(selected_n.g_score);
                retracePath(selected_n,0);
                return;
            }
            openList.remove(sel_ind);
            closedList.add(selected_n);
            neighbourList=(selected_n.n).getNeighbours(selected_n.g_score,selected_n);
            it=neighbourList.iterator();
            int ind;
            while(it.hasNext()){
                temp_n=(listNode)it.next();
                int tentative_g_score = temp_n.g_score; 
                if(closedList.contains(temp_n)){
                    ind=closedList.indexOf(temp_n);
                    if (tentative_g_score>=closedList.get(ind).g_score) continue;
                    else
                    {
                        closedList.set(ind, temp_n);
                    }
                }
                if(!openList.contains(temp_n)){
                    if(!closedList.contains(temp_n))openList.add(temp_n);
                }
                else
                {
                    ind=openList.indexOf(temp_n);
                    if (tentative_g_score>=openList.get(ind).g_score) continue;
                    else
                    {
                        openList.set(ind, temp_n);
                    }
                }
                
            }    
        }
        System.out.println("No path from Start to Goal");
    }
    private void retracePath(listNode cur_n,int num)
    {
        System.out.println("Node number : "+num+"\n");
        (cur_n.n).printNode();
        if(cur_n.parent!=null){
            retracePath(cur_n.parent,num+1);
        }
    }
}
