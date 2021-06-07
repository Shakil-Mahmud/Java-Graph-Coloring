/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphColoring;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Ayomitunde
 */
public class Algorithms {

    private GraphifyGUI GG;
    HashMap<Integer, Integer> connectionCache = new HashMap<>();
    private HashMap<Integer, Integer> glowMap = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> nodes;
    private Queue<Integer> queue;
    private Stack<Integer> stack;
    private HashMap<Integer, Integer> distTo;
    private HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> visited;
    private HashMap<Integer, Integer> color;
    private HashMap<Integer, Integer> greedyresult;
    private HashSet<Integer> _colors2;
    private ArrayList<Integer> conn;
    private ArrayList<Integer> bconn;
    private ArrayList<Integer> cutV;
    private ArrayList<Integer> nodeColors;
    private Color[] vertexColors;
    int _selectedNode = -1;
    int _SIZE_OF_NODE = 20;
    int id = 0;
    int time = 0;
    Integer maxColors = 0;
    int _source;
    int _dest;
    int totalColors = 3;

    public Algorithms(GraphifyGUI GG) {
        this.GG = GG;
        this.nodes = new HashMap<>();
        this.queue = new LinkedList<>();
        this.stack = new Stack<>();
        this.cutV = new ArrayList<>();
        this._colors2 = new HashSet<>();
        this.visited = new HashMap<>();
        this.set = new HashMap<>();
        this.visited = new HashMap<>();
        this.color = new HashMap<>();
        this.greedyresult = new HashMap<>();
        this.vertexColors = new Color[]{Color.blue, Color.red, Color.yellow, Color.green, Color.magenta, Color.orange};
    }


    boolean Consistent(int color, int var, int TotalNodes){
        
        HashSet<Integer> list = getEdge(var);
        Iterator<Integer> it = list.iterator();
        
        while(it.hasNext()){
            int temp = it.next();
            
            if( color==GG.greedyresult.get(temp) )
                return false;
        }

        return true;
    }

    boolean Backtrack(int TotalNodes, int currNode ){
        if(currNode>=TotalNodes)
            return true;
        
        for(int i=0 ; i<totalColors ; i++){
            if(Consistent(i, currNode, TotalNodes)==true){
                
                GG.greedyresult.put(currNode, i);
                boolean result = Backtrack(TotalNodes, currNode+1);
                
                if(result==true)
                    return true;
            }
        }
        return false;
    }

    boolean GCBacktrack() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        nodes = GG.getNode();        
        int totalNodes = nodes.size();
            
        for(int i=0 ; i<totalNodes; i++)
            GG.greedyresult.put(i, -1);
        
        boolean flage = Backtrack(totalNodes,0);
        return flage;
    }

    public HashSet<Integer> getEdge(int source) {
        nodes = GraphifyGUI.getNode();
        return nodes.get(source);
    }    
    
    public Queue getQueue() {
        return this.queue;
    }

    public Stack getStack() {
        return this.stack;
    }


    public HashMap getVisited() {
        return this.visited;
    }

    public ArrayList getCutV() {
        return this.cutV;
    }


    public HashMap getGlowMap() {
        return this.glowMap;
    }

    public HashMap distTo() {
        return this.distTo;
    }

    public HashMap getSet() {
        return this.set;
    }

    public HashMap getColor() {
        return this.color;
    }

    public HashMap getGreedyResult() {
        return this.greedyresult;
    }

    public HashSet getColors2() {
        return this._colors2;
    }

    public ArrayList getConn() {
        return this.conn;
    }

    public ArrayList getBConn() {
        return this.bconn;
    }


    public Color[] getVertexColors() {
        return this.vertexColors;
    }



}
