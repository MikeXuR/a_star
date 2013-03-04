/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author akshay
 */
public class ASTAR {

    /**
     * @param args the command line arguments
     */
    
    private List<listNode> openList;
    private List<listNode> closedList;
    
    public void findBestPath(Graph graph,int source,int goal)
    {
        openList= new ArrayList<listNode>();
        closedList= new ArrayList<listNode>();
        listNode lnode=new listNode(graph.getNodeByNum(source),0);
        openList.add(lnode);
        listNode selected_n=new listNode();
        listNode temp_n;
        int min=-1;
        int f_score;
        List<listNode> neighbourList;
        while(!openList.isEmpty())
        {
            Iterator it=openList.iterator();
            while(it.hasNext())  // selecting the minimum fscore node to expand
            {
                
                    temp_n=(listNode)it.next();
                    f_score=temp_n.g_score+graph.heuristic_cost_estimate(temp_n.n);
                    if(min<0||f_score<min)
                    {
                        min=f_score;
                        selected_n=temp_n;  //node to be expanded
                        System.out.println("Node selected is"+selected_n.n.num);
                    }
                    
            }
            if((selected_n.n).num==goal)
            {
                closedList.add(selected_n);
                System.out.println(selected_n.g_score);
                break;
            }
            openList.remove(selected_n);
            closedList.add(selected_n);
            neighbourList=graph.getNeighbours(selected_n);
            it=neighbourList.iterator();
            while(it.hasNext()){
                temp_n=(listNode)it.next();
                int tentative_g_score = selected_n.g_score + graph.getWeight(selected_n.n,temp_n.n); 
                if(closedList.contains(temp_n)){
                    if (tentative_g_score>=temp_n.g_score) continue;
                }
                if((!openList.contains(temp_n)) || (tentative_g_score < temp_n.g_score)){
                    temp_n.g_score = tentative_g_score;
                    
                    if(!openList.contains(temp_n))openList.add(temp_n); //Need to think here
                }
                
            }    
        }
        return ;
    }

   public static void main(String[] args) {
        // TODO code application logic here
        Graph g=new Graph();
        for(int i=0;i<10;i++)
        {
            node n=new node(i);
            (g.nodes).add(n);
        }
        for(int i=1;i<5;i++)
        {
            edge e=new edge(0+i,g.getNodeByNum(0),g.getNodeByNum(i));
            (g.edges).add(e);
        }
        for(int i=1;i<5;i++)
        {
            edge e=new edge(4+2*i,g.getNodeByNum(i),g.getNodeByNum(4+i));
            (g.edges).add(e);
        }
        for(int i=5;i<9;i++)
        {
            edge e=new edge(9+i,g.getNodeByNum(i),g.getNodeByNum(9));
            (g.edges).add(e);
        }
     //   findBestPath(g,0,9);
        //define heurisstic function
        
    }
}
