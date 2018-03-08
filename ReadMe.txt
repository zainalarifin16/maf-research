HelloWorld
This is a "hello world" application for MAF, which demonstrates the basic structure of the framework. This basic application has a single application feature that is implemented with a local HTML file. Use this application to ascertain that the development environment is set up correctly to compile and deploy an application.

ACS
This application provides the REST services that are used within the SecurityDemo application to configure the login server and the Access Control Service. This web application needs to be deployed on a WebLogic server.

APIDemo
This application demonstrates how to invoke custom JavaScript methods from within a MAF AMX page. Use this approach to invoke the Apache Cordova APIs that are not included in the DeviceFeatures data control. You can also use this approach to add custom JavaScript methods to an application as well as invoke these methods. In addition, this application demonstrates how to call back to Java from the JavaScript methods.

BarcodeDemo
This application demonstrates how to make use of a Cordova plugin by calling the BarcodeScanner plugin from embedded JavaScript that is invoked from a backing bean.

BeaconDemo
This application demonstrates how to make use of a Cordova plugin to detect iBeacons.

CompGallery
This application serves as an introduction to the MAF AMX UI components by demonstrating all of the components. Using this application, you can change the attributes of these components and see the effects of those changes in real time without recompiling and redeploying the application after each change.

ConfigServiceDemo
This application demonstrates the use of the Configuration Service to change the end points used in a MAF application. Changes to end points in the connections.xml file are propagated to the application on the mobile device and the application reinitializes to consume the new end points. This application is used with the ACS sample application, which hosts the remote connections.xml file.

CRUDDemo
This application demonstrates how to build CRUD operations using the SQLite database and Java bean data controls. This application displays a list of employees and allows you to create, update, and delete employees. This application uses a local SQLite database to store its data, persisting the data during CRUD operations. In addition, this application shows how to use CREATE and DELETE operations to add or delete items to and from a collection.

DeviceDemo
This application demonstrates how to use the DeviceFeatures data control to expose mobile device features such as geolocation, email, SMS, and contacts, as well as how to query the mobile device for its properties. This application also demonstrates how to use the displayFile method from the DeviceFeatures data control to display various file types such as .doc, .ppt, .xls, and .png. You must run this application on an actual mobile device, because SMS and some of the device properties do not function on an iOS simulator or Android emulator.

ExpandCollapseComponent
This application demonstrates how to create a custom component that can act as a container for any type of MAF AMX component. It also provides an example of expand and collapse functionality. For details, see the cardview.js file in the js folder of the application. This JavaScript file contains a method (expandcollapse.prototype.render) that renders the UI of the component. It also contains a method that demonstrates how to render the child components of the custom UI component.

FakeBeacon
This application demonstrates how to make use of a Cordova plugin to pretend to be an iBeacon. This application can be used in conjunction with the BeaconDemo application if you do not have an actual iBeacon for testing.

FragmentDemo
This application demonstrates how to use fragments to define reusable artifacts that can be used as templates. It shows how you can have multiple content types for each application feature (for example, one for tablet, one for phone) and use the fragment so that you do not have to code the list or form every time. It shows how to use static attributes as well as a variable list of attributes sent into the fragment. It also shows how to expose facets and popup components embedded within a fragment.

GestureDemo
This application demonstrates how gestures can be implemented and used in MAF applications.

LayoutDemo
This application demonstrates various MAF AMX UI constructs and techniques, focusing on variety of page layouts (flowing, stretch, or split view).

LifecycleEvents
This application implements lifecycle event handlers on the MAF application itself and its embedded application features. This application shows you where to insert code to enable the applications to perform their own logic at certain points in the lifecycle. 

LocalNotificationDemo
This application demonstrates how to schedule and receive local notifications within a MAF application.

Navigation
This application demonstrates the various navigation techniques in MAF, including bounded task flows and routers. It also demonstrates page transitions.

PrefDemo
This application demonstrates application-wide and application feature-specific user setting pages.

PushDemo
This application demonstrates how to register for and receive push notifications from the Apple Push Notification and Google Could Messaging servers. This application registers with the Apple Push Notification service (APNs) or the Google Cloud Messaging (GCM) server, as appropriate, and enables the user to register a unique user ID with the server application. From the server application, it is possible to fire a push notification via APNs or GCM to the mobile device running this application and, ultimately, the message contained in the push notification will be displayed in this application. This application is used with the PushServer sample application, which provides the ability to initiate a push notification.

PushServer
This web application works in conjunction with the PushDemo application to demonstrate how to implement push notifications. This web application needs to be deployed on a Weblogic server.

RangeChangeDemo
This application demonstrates how to use a RangeChangeEvent to invoke a Java handler method when the MAF AMX List View component requires new data to be fetched from an external source.It also demonstrates how to configure the scrolling and buffering behavior of a List View component using its attributes.

SecurityDemo
This application demonstrates how to secure a MAF application, configure authentication and the login server, use the Access Control Service, and access secure web services. This application is used with the ACS sample application, which provides the REST services used to configure the login server and the Access Control Service.

SkinningDemo
This application demonstrates how to skin MAF applications and add a unique look and feel by either overriding the supplied style sheets or extending them with their own style sheets. This application also shows how skins control the styling of MAF AMX UI components based on the type of mobile device. It also demonstrates the ability to change skin families (out-of-the-box or custom) at runtime.

SlidingWindows
This application demonstrates the use of the AdfmfSlidingWindowUtilities API, which can be used to display multiple MAF application features on the screen at the same time. This application shows how you can create a custom springboard or a global navigation bar using the AdfmfSlidingWindowUtilities API.

StockTracker
This application demonstrates how data change events use Java to enable data changes to be reflected in the user interface. In addition, this application provides a variety of UI layout use cases, gestures, and basic mobile patterns. This application also demonstrates how to enable the client-side validation by using the MAF AMX Validation Group component (see the editStock.amx included in the Portfolio part).

URLSchemeDemo
This application demonstrates how to define a custom URL scheme for a MAF application so that you can invoke it from a URL link in a browser, email, or another application.

WorkBetter
This human resources application allows several different roles to perform a simulated login to the application to obtain different dashboard data. From there, the organization's critical data can be viewed, The data, such as performance, compensation, and timeline-related information, is displayed via various data visualization components. In addition, the application contains an employee directory and provides a way to view profiles of specific employees.  The application demonstrates the capabilities of the MAF AMX UI component set, particularly the data visualization components that can be used to create a very compelling UI. The application navigation demonstrates how to define task flows to incorporate reusable parts of the application, as well as perform deep drilling and backing out of those task flows. This application provides an extensive demonstration of various MAF AMX UI techniques and components, such as UI layout patterns and uses for both common and more complex UI components.  Note: This is not a compete MAF application that takes advantage of all the device features, but rather a showcase of the MAF AMX UI capabilities. Consult other MAF sample applications for demonstrations of device feature integration, data persistence to the local SQLite database, data create, update, and delete patterns, and so on.