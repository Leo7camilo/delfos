export const environment = {
  production: true,
  apiUrl: 'https://delfos-api.herokuapp.com',
  tokenAllowedDomains: [ /algamoney-api.herokuapp.com/ ],
  tokenDisallowedRoutes: [/\/oauth2\/token/],
  oauthCallbackUrl: 'https://delfos-api.herokuapp.com',
  logoutRedirectToUrl: 'https://delfos-api.herokuapp.com'
};
