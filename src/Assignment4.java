
public class Assignment4 {
	int[][] implemetFcfs(int arival_time[], int job_size[]) {
        int len = arival_time.length;
        int result[][] = new int[len][5];
        int waiting_time[] = new int[len];
        /*
         job num | arival_time | waiting_time | start_time | finished_time
                 |             |              |            |              
                 |             |              |            |              
                 |             |              |            |              
                 |             |              |            |              
        */
        waiting_time[0] = 0;
        //job_number
        result[0][0] = 1;
        //arival time
        result[0][1] = arival_time[0];
        //waiting time
        result[0][2] = waiting_time[0];
        //start time
        result[0][3] = arival_time[0];
        //finished time
        result[0][4] += job_size[0];

        int index;
        for (index = 1; index < len; index++) {
            
            //job number
            result[index][0] = index+1;
            //arrival time
            result[index][1] = arival_time[index];
          
            
            if(arival_time[index]<result[index-1][4]) {
                waiting_time[index] += (1 + result[index-1][4] - arival_time[index]);
                result[index][2] = waiting_time[index];
                //start time
                result[index][3] = result[index-1][4]+1;
            }
            else if(arival_time[index] > result[index-1][4]) {
                waiting_time[index] = 0;
                result[index][2] = 0;
                
                //start time
                result[index][3] = arival_time[index];
            }
               //finish_time = start_time + job_size
                result[index][4] += (result[index][3]+job_size[index] - 1);
        }

        return result;
    }
}
