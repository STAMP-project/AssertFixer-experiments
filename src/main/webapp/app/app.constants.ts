// These constants are injected via webpack environment variables.
// You can add more variables in webpack.common.js or in profile specific webpack.<dev|prod>.js files.
// If you change the values in the webpack config files, you need to re run webpack to update the application

export const VERSION = process.env.VERSION;
export const DEBUG_INFO_ENABLED: boolean = !!process.env.DEBUG_INFO_ENABLED;
export const SERVER_API_URL = process.env.SERVER_API_URL;
export const BUILD_TIMESTAMP = process.env.BUILD_TIMESTAMP;

export const SSO_URL =
    process.env.SSO_URL ||
    'https://login.eveonline.com/oauth/authorize/?response_type=code' +
        '&redirect_uri=http%3A%2F%2Flocalhost%3A9000%2F%23%2Fcallback&client_id=51d157911f5e419ea9f97137a516e1ef' +
        '&scope=&state=login';
