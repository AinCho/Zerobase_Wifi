/**
 * 
 */
function geoFindMe() {

  const status = document.querySelector('#status');
  const mapLink = document.querySelector('#map-link');

  mapLink.href = '';
  mapLink.textContent = '';

  function success(position) {
    const latitude  = position.coords.latitude;
    const longitude = position.coords.longitude;

    status.textContent = '';
    mapLink.href = `https://www.openstreetmap.org/#map=18/${latitude}/${longitude}`;
    mapLink.textContent = `Lat: ${latitude} °, LNT: ${longitude} °`;
  }

  function error() {
    status.textContent = '위치를 찾을 수 없습니다 ';
  }

  if(!navigator.geolocation) {
    status.textContent = '귀하의 브라우져는 정보 제공이 불가합니다 ';
  } else {
    status.textContent = 'Locating…';
    navigator.geolocation.getCurrentPosition(success, error);
  }

}

document.querySelector('#find-me').addEventListener('click', geoFindMe);