# Use case: AAS-Management
Creating, Updating, Deleting, in general words managing of Asset Administration Shells is difficult! You do not only need the knowledge, there is also no solid working Desktop application which allows you to view and manage Asset Administration Shells. 

The following document specifies the sub use cases of managing an Asset Administration Shell.

For Software Requirements and Design Documentation look [here](SDD-AasManager.md).

## Sub use case: Request, Retrieve and Display a specific AAS for human interaction: 
In nearly all cases the AAS are stored and organized inside of an AAS-Environment. This means all AAS are available through network based requests.

### Actor
- User

### Trigger
- need to look into/up an specific AAS

### Preconditions
1. AAS-Management-Communication-Service has verified access.
2. User has verified access.

### Basic workflow
| Description         | This scenario describes the generic workflow of the use case.             |
| ------------------- | ------------------------------------------------------------------------- |
| 1                   | Define which AAS has to be identified.                                    |
| 2                   | Open AAS-Management-Communication-Service.                                |
| 3                   | Insert AAS-Trigger-Information into AAS-Management-Communication-Service. |
| 4                   | Wait for AAS-Management-Communication-Service to complete the Request.    |
| 5                   | Use displayed AAS-Information.                                            |
| Termination Outcome | User closes AAS-Information-Window.                                       |

#### Alternative Flow 4A: Service Request is not successful
| Description         | This scenario describes the alternative flow of failed Request for AAS Information. |
| ------------------- | ----------------------------------------------------------------------------------- |
| 4A                  | AAS-Management-Communication-Service verifies: "yes indeed there is a problem".     |
| 4B                  | AAS-Management-Communication-Service compares Error with Error-Catalog.             |
| 4C                  | AAS-Management-Communication-Service generates Error messages.                      |
| Termination Outcome | Error messages is shown to user with further instructions.                          |

## Sub use case: Load and display AAS from file:
Sometimes AAS are stored locally. The reason for this scenario are many.

### Actor
- User

### Trigger
- need to look into/up a locally stored AAS

### Preconditions
- AAS-Manager has the right to read local directories.
- User has verified access to the local system.

### Basic workflow
| Description         | This scenario describes the generic workflow of the use case. |
| ------------------- | ------------------------------------------------------------- |
| 1                   | Define which AAS-File has to be loaded.                       |
| 2                   | Open AAS-Management-Communication-Service.                    |
| 3                   | Insert AAS-Local-Path.                                        |
| 4                   | Wait for AAS-Management-Communication-Service to load File.   |
| 5                   | Use displayed AAS-Information.                                |
| Termination Outcome | User closes AAS-Information-Window.                           |

#### Alternative Flow 4A: loading File is not successful
| Description         | This scenario describes the alternative flow of failed Request for AAS Information. |
| ------------------- | ----------------------------------------------------------------------------------- |
| 4A                  | AAS-Management-Communication-Service verifies: "yes indeed there is a problem".     |
| 4B                  | AAS-Management-Communication-Service compares Error with Error-Catalog.             |
| 4C                  | AAS-Management-Communication-Service generates Error messages.                      |
| Termination Outcome | Error messages is shown to user with further instructions.                          |

## Sub use case: Validate given AAS:
Every AAS has to follow specific constraints. To make sure any given AAS is valid, it has to be put through a Validator-Service.

### Actor
- User

### Trigger
- AAS needs to be validated

### Preconditions
- AAS-Manager has the right to access the AAS File.
- User has verified access.

### Basic workflow
| Description         | This scenario describes the generic workflow of the use case. |
| ------------------- | ------------------------------------------------------------- |
| 1                   | Define which AAS-File has to be validated.                    |
| 2                   | Open AAS-Management-Validation-Service.                       |
| 3                   | Insert AAS-Location.                                          |
| 4                   | Wait for AAS-Management-Validation-Service to validate File.  |
| 5                   | Use displayed Validation-Report-Information.                  |
| Termination Outcome | User closes AAS-Validation-Report-Window.                     |

#### Alternative Flow 4A: loading File is not successful
| Description         | This scenario describes the alternative flow of failed Request for AAS Information. |
| ------------------- | ----------------------------------------------------------------------------------- |
| 4A                  | AAS-Management-Validation-Service verifies: "yes indeed there is a problem".        |
| 4B                  | AAS-Management-Validation-Service compares Error with Error-Catalog.                |
| 4C                  | AAS-Management-Validation-Service generates Error messages.                         |
| Termination Outcome | Error messages is shown to user with further instructions.                          |

## Sub use case: Create and serialize an AAS:
One of the main features of the Manager is the ability to create an AAS andd serialize it to a given format of choice. Available formats will be defined by the AAS-specification.

### Actor
- User

### Trigger
- creating an AAS

### Preconditions
- none

### Basic workflow
| Description         | This scenario describes the generic workflow of the use case. |
| ------------------- | ------------------------------------------------------------- |
| 1                   | Open AAS-Creation-Tool.                                       |
| 2                   | Create AAS inside the AAS-Creation-Tool.                      |
| 3                   | Save file and choose desired serialization format.            |
| 4                   | Wait for AAS-Creation-Tool to end process.                    |
| 5                   | Read Serialization Report.                                    |
| Termination Outcome | User closes AAS-Information-Window.                           |

#### Alternative Flow 4A: loading File is not successful
| Description         | This scenario describes the alternative flow of failed Request for AAS Information. |
| ------------------- | ----------------------------------------------------------------------------------- |
| 4A                  | AAS-Creation-Tool verifies: "yes indeed there is a problem".                        |
| 4B                  | AAS-Creation-Tool compares Error with Error-Catalog.                                |
| 4C                  | AAS-Creation-Tool generates Error messages.                                         |
| Termination Outcome | Error messages is shown to user with further instructions.                          |