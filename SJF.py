n = int(input("\nEnter number of processes : "))
processes=list(map(int,input("\nEnter the PID : ").strip().split()))[:n]
burst_time = list(map(int,input("\nEnter the burst time : ").strip().split()))[:n] 
arrival_time = list(map(int,input("\nEnter the arrival time : ").strip().split()))[:n]
for i in range(0,len(burst_time)-1):
      for j in range(0,len(burst_time)-i-1):
            if(burst_time[j]>burst_time[j+1]):
                  temp=burst_time[j]
                  burst_time[j]=burst_time[j+1]
                  burst_time[j+1]=temp
                  temp=processes[j]
                  processes[j]=processes[j+1]
                  processes[j+1]=temp
wt=[]
avgwt=0
tat=[]
avgtat=0
wt.insert(0,0)
tat.insert(0,burst_time[0])
for i in range(1,len(burst_time)):  
      wt.insert(i,wt[i-1]+burst_time[i-1])
      tat.insert(i,wt[i]+burst_time[i])
      avgwt+=wt[i]
      avgtat+=tat[i]
avgwt=float(avgwt)/n
avgtat=float(avgtat)/n
print("\nProcess\t  Burst Time\t  Waiting Time\t  Turn Around Time")
for i in range(0,n):
      print(str(processes[i])+"\t\t"+str(burst_time[i])+"\t\t"+str(wt[i])+"\t\t"+str(tat[i]))
print("\nAverage Waiting time is: "+str(avgwt))
print("Average Turn Arount Time is: "+str(avgtat))