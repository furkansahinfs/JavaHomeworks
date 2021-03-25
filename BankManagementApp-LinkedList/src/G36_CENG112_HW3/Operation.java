package G36_CENG112_HW3;

public class Operation {

	public void operation() {
		// I create necessary things.
		FileIO fileIO = new FileIO();
		TransactionQueueList<TransactionQueue> linkedqueueslist = fileIO.readFile();

		linkedqueueslist.toStringTQ("01.05.2019"); // To see the info of dates I use that method.
		linkedqueueslist.toStringTQ("02.05.2019"); // To see the info of dates I use that method.
		linkedqueueslist.toStringTQ("03.05.2019"); // To see the info of dates I use that method.
		linkedqueueslist.toStringTQ("04.05.2019"); // To see the info of dates I use that method.
		linkedqueueslist.toStringTQ("05.05.2019"); // To see the info of dates I use that method.

		// To see statictis just SET DATE AND/OR PRIORITY.
		System.out.println("Total transaction count in " + linkedqueueslist.getTQ("05.05.2019").getDate() + ": "
				+ linkedqueueslist.getTQ("05.05.2019").getLength());
		// To see statictis just SET DATE AND/OR PRIORITY.
		System.out.println("Total waiting time in " + linkedqueueslist.getTQ("05.05.2019").getDate() + ": "
				+ linkedqueueslist.getTQ("05.05.2019").TotalWaitingTime());
		// To see statictis just SET DATE AND/OR PRIORITY.
		System.out.println("Average waiting time in " + linkedqueueslist.getTQ("05.05.2019").getDate() + ": "
				+ linkedqueueslist.getTQ("05.05.2019").AverageWaitingTime());
		// To see statictis just SET DATE AND/OR PRIORITY.
		System.out.println("Total transaction count for CORPORATE in " + linkedqueueslist.getTQ("05.05.2019").getDate()
				+ ": " + linkedqueueslist.getTQ("05.05.2019").SpecificTransaction("CORPORATE"));
		// To see statictis just SET DATE AND/OR PRIORITY.
		System.out.println("Total waiting time for CORPORATE in " + linkedqueueslist.getTQ("05.05.2019").getDate()
				+ ": " + linkedqueueslist.getTQ("05.05.2019").TWTSpecific("CORPORATE"));
		// To see statictis just SET DATE AND/OR PRIORITY.
		System.out.println("Average waiting time for CORPORATE in " + linkedqueueslist.getTQ("05.05.2019").getDate()
				+ ": " + linkedqueueslist.getTQ("05.05.2019").AWTSpecific("CORPORATE"));

		System.out.println(
				"The date with the highest workload(max total waiting time) " + linkedqueueslist.maxWorkload());

	}
}
