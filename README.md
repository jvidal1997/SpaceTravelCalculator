# Space Travel Calculator



This tool can be thought of as a commercial space-flight manager. It allows a user to choose two planetary bodies, a starting planet and a destination planet, as well as a vehicle for transport. It then runs the necessary calculations to determine various metrics for the trip. These include scientific calculations, such as gravity assist with a drag coefficient, and financial calculations, such as crew expenses, and much more. The results for each trip are then displayed in a table, offering the user an option to add another trip or export the results to a new Excel spreadsheet (XLSX).

## How it works
The program uses a properties file to locate it's data resources. There are three required files: a planet & vehicle spreadsheet (XLSX), a planetary constants file (XML), and a contact information file (XML). I've provided an ```app.properties``` file to start with. The values of the properties can be manipulated to point to any file you choose on your pc. In the source code, these are all stored in the ```src/main/java/resources/lesson06``` folder. However, when installing from the latest release, a resource folder will be required to get you up and running. It can be found on the release page. To keep it simple, a user can simply change the ```app.resources.path``` in the ```app.properties``` file to point to their own resources folder. All other values point to files by name & extension within that resources folder.

Upon initial launch of the program, you will be prompted to choose your properties file. From there, you can add your trips to the itinerary, view your results, and export them to a spreadsheet.

## Manipulating the data files
As previously stated there are three data files:
  - Planet & Vehicle data
  - Constants (for calculations)
  - Contact information

Firstly, updating the contact XML file to contain your own contact information is highly encouraged, if you'd like your own information contained in the output file. Secondly, all of the headers in the provided ```Planets.xlsx``` file are required for the program to run. Though you're welcome to change values and add new fields. Lastly, the constants file works to the same way; values can be changed; but, they are required for the program to work properly.

If you're working within the source code, I'm sure you already know that everything is on the table. All data, files, etc., are mutable. Below are some diagrams for showing how the program works under the hood. Enjoy!

## UML Diagrams

### Utilities (left) & Abstract Overview (right)

<img width="3300" height="2550" alt="STC-Diagram-p1" src="https://github.com/user-attachments/assets/c992ade1-1b30-43c8-b443-d8e222990d48" />

### Program Workflow

<img width="3300" height="2550" alt="STC-Diagram-p2" src="https://github.com/user-attachments/assets/8e9f17f5-0ce5-44ae-b9d6-aa3325535872" />

### Data Objects

<img width="3300" height="2550" alt="STC-Diagram-p3" src="https://github.com/user-attachments/assets/60f18414-fb91-4539-a834-7e5111a470d3" />

### Java Objects
<img width="3300" height="2550" alt="STC-Diagram-p4" src="https://github.com/user-attachments/assets/bafaa395-66fe-4ca4-8722-861aa6df6840" />
